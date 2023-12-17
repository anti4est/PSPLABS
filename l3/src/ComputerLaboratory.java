public class ComputerLaboratory extends Laboratory{
    private int computerNumber;

    public ComputerLaboratory(){
        super();
        this.computerNumber = 0;
    }
    public ComputerLaboratory(String teacher, String subject, int number, String course, int computerNumber){
        super(teacher, subject, number, course);
        this.computerNumber = computerNumber;
    }
    public int getComputerNumber() {
        return computerNumber;
    }
    public void printName(){
        System.out.println("\nTeacher of computer lab: " + teacher);
    }
    public String getType(){
        return "Computer lab";
    }
    public void printInfo(){
        System.out.println("\nSubject: " + subject + "\nNumber: " + number + " \nCourse: " + course);
        System.out.println("Number of computers: " + computerNumber);
    }
}