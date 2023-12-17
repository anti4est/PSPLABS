public class Сlassroom implements Objects, Auditorium{
    private String teacher;
    private String subject;
    private int number;
    private String course;
    private int numberChair;
    public Сlassroom(){
        this.teacher = "N/A";
        this.subject = "N/A";
        this.number = 0;
        this.course = "N/A";
        this.numberChair = 0;
    }
    public Сlassroom(String teacher, String subject, int number, String course, int numberChair){
        this.teacher = teacher;
        this.subject = subject;
        this.number = number;
        this.course = course;
        this.numberChair = numberChair;
    }
    public String getSubject(){
        return subject;
    }
    public String getCourse(){
        return course;
    }
    public int getNumber(){
        return number;
    }
    public int getNumberChair(){
        return numberChair;
    }
    public void printName(){
        System.out.println("\nTeacher of classroom: " + teacher);
    }
    public void printInfo(){
        System.out.println("\nSubject: " + subject + "\nNumber: " + number + "\nCourse: " + course);
        System.out.println("Number of chairs: " + numberChair);
    }
}