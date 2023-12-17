import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockApp extends JFrame {
    private ClockPanel clockPanel;
    private JButton startButton;
    private JButton stopButton;
    private JSpinner alarmSpinner;
    private JButton setAlarmButton;

    private Timer clockTimer;
    private Timer alarmTimer;
    private boolean isClockRunning;
    private boolean isAlarmSet;

    public ClockApp() {
        setTitle("Часы");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        clockPanel = new ClockPanel();
        startButton = new JButton("Старт");
        stopButton = new JButton("Стоп");
        alarmSpinner = new JSpinner(new SpinnerDateModel());
        setAlarmButton = new JButton("Установить будильник");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startClock();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopClock();
            }
        });

        setAlarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAlarm();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(alarmSpinner);
        buttonPanel.add(setAlarmButton);

        setLayout(new BorderLayout());
        add(clockPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        isClockRunning = false;
        isAlarmSet = false;
    }

    private void startClock() {
        if (!isClockRunning) {
            isClockRunning = true;
            startButton.setEnabled(false);
            stopButton.setEnabled(true);

            clockTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clockPanel.updateTime();
                    checkAlarm();
                }
            });
            clockTimer.start();
        }
    }

    private void stopClock() {
        if (isClockRunning) {
            isClockRunning = false;
            startButton.setEnabled(true);
            stopButton.setEnabled(false);

            if (clockTimer != null) {
                clockTimer.stop();
                clockTimer = null;
            }
        }
    }

    private void setAlarm() {
        if (!isAlarmSet) {
            isAlarmSet = true;
            setAlarmButton.setEnabled(false);

            Calendar alarmTime = Calendar.getInstance();
            alarmTime.setTime((java.util.Date) alarmSpinner.getValue());

            alarmTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Calendar currentTime = Calendar.getInstance();

                    if (currentTime.get(Calendar.HOUR_OF_DAY) == alarmTime.get(Calendar.HOUR_OF_DAY) &&
                            currentTime.get(Calendar.MINUTE) == alarmTime.get(Calendar.MINUTE) &&
                            currentTime.get(Calendar.SECOND) == alarmTime.get(Calendar.SECOND)) {
                        JOptionPane.showMessageDialog(ClockApp.this, "Будильник сработал!");
                        stopAlarm();
                    }
                }
            });
            alarmTimer.start();
        }
    }

    private void stopAlarm() {
        if (isAlarmSet) {
            isAlarmSet = false;
            setAlarmButton.setEnabled(true);

            if (alarmTimer != null) {
                alarmTimer.stop();
                alarmTimer = null;
            }
        }
    }

    private void checkAlarm() {
        if (isAlarmSet) {
            Calendar currentTime = Calendar.getInstance();
            Calendar alarmTime = Calendar.getInstance();
            alarmTime.setTime((java.util.Date) alarmSpinner.getValue());

            if (currentTime.compareTo(alarmTime) >= 0) {
                stopAlarm();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClockApp clockApp = new ClockApp();
                clockApp.setVisible(true);
            }
        });
    }
}