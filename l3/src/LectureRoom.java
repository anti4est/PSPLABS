public class LectureRoom implements Objects, Auditorium{
    private String teacher;
    private String subject;
    private int number;
    private String course;
    private int numberFaculty;

    public LectureRoom(){
        this.teacher = "N/A";
        this.subject = "N/A";
        this.number = 0;
        this.course = "N/A";
        this.numberFaculty = 0;

    }
    public LectureRoom(String teacher, String subject, int number, String course, int numberFaculty){
        this.teacher = teacher;
        this.subject = subject;
        this.number = number;
        this.course = course;
        this.numberFaculty = numberFaculty;

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
    public void printName(){
        System.out.println("\nTeacher of lecture room: " + teacher);
    }
    public void printInfo(){
        System.out.println("\nSubject: " + subject + "\nNumber: " + number + "\nCourse: " + course);
        System.out.println("Number of faculties: " + numberFaculty);
    }
}