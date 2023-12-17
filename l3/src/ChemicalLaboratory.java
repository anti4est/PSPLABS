public class ChemicalLaboratory extends Laboratory{
    private int chemicalNumber;
    public ChemicalLaboratory(){
        super();
        this.chemicalNumber = 0;
    }
    public ChemicalLaboratory(String teacher, String subject, int number, String course, int chemicalNumber){
        super(teacher, subject, number, course);
        this.chemicalNumber = chemicalNumber;
    }
    public int getChemicalNumber() {
        return chemicalNumber;
    }
    public void printName(){
        System.out.println("\nTeacher of chemical: " + teacher);
    }
    public String getType(){
        return "Chemical lab";
    }
    public void printInfo(){
        System.out.println("\nSubject: " + subject + "\nNumber: " + number + "\nCourse: " + course);
        System.out.println("Number of chemicals: " + chemicalNumber);
    }
}