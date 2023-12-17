public abstract class Laboratory implements Objects, Auditorium {
    protected String teacher;
    protected String subject;
    protected int number;
    protected String course;

    public Laboratory(){
        this.teacher = "N/A";
        this.subject = "N/A";
        this.number = 0;
        this.course = "N/A";
    }
    public Laboratory(String teacher, String subject, int number, String course){
        this.teacher = teacher;
        this.subject = subject;
        this.number = number;
        this.course = course;
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
    public abstract String getType();
}