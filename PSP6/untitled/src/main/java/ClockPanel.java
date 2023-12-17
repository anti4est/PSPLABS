import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

class ClockPanel extends JPanel {
    private int hour;
    private int minute;
    private int second;

    public ClockPanel() {
        hour = 0;
        minute = 0;
        second = 0;
    }

    public void updateTime() {
        Calendar currentTime = Calendar.getInstance();

        hour = currentTime.get(Calendar.HOUR_OF_DAY);
        minute = currentTime.get(Calendar.MINUTE);
        second = currentTime.get(Calendar.SECOND);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int centerX = width / 2;
        int centerY = height / 2;
        int radius = Math.min(centerX, centerY) - 10;

        // Отрисовка циферблата
        g.setColor(Color.WHITE);
        g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        // Отрисовка стрелок
        int hourHandLength = radius * 2 / 5;
        int minuteHandLength = radius * 3 / 5;
        int secondHandLength = radius * 4 / 5;

        int hourHandAngle = (hour % 12) * 30 + minute / 2;
        int minuteHandAngle = minute * 6 + second / 10;
        int secondHandAngle = second * 6;

        int hourHandX = (int) (centerX + hourHandLength * Math.sin(Math.toRadians(hourHandAngle)));
        int hourHandY = (int) (centerY - hourHandLength * Math.cos(Math.toRadians(hourHandAngle)));
        int minuteHandX = (int) (centerX + minuteHandLength * Math.sin(Math.toRadians(minuteHandAngle)));
        int minuteHandY = (int) (centerY - minuteHandLength * Math.cos(Math.toRadians(minuteHandAngle)));
        int secondHandX = (int) (centerX + secondHandLength * Math.sin(Math.toRadians(secondHandAngle)));
        int secondHandY = (int) (centerY - secondHandLength * Math.cos(Math.toRadians(secondHandAngle)));

        g.setColor(Color.BLACK);
        g.drawLine(centerX, centerY, hourHandX, hourHandY);
        g.drawLine(centerX, centerY, minuteHandX, minuteHandY);
        g.setColor(Color.RED);
        g.drawLine(centerX, centerY, secondHandX, secondHandY);

        // Отрисовка центральной точки
        g.setColor(Color.BLACK);
        g.fillOval(centerX - 5, centerY - 5, 10, 10);

        // Отрисовка цифр на циферблате
        g.setFont(new Font("Arial", Font.BOLD, 16));
        FontMetrics fm = g.getFontMetrics();
        for (int i = 1; i <= 12; i++) {
            double angle = Math.toRadians((i+2) * 30 - 60);
            int x = (int) (centerX + (radius - 20) * Math.sin(angle));
            int y = (int) (centerY - (radius - 20) * Math.cos(angle));
            String number = Integer.toString(i);
            int numberWidth = fm.stringWidth(number);
            g.drawString(number, x - numberWidth / 2, y + fm.getAscent() / 2);
        }
    }
}