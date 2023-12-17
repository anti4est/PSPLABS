public class Main {
    public static void main(String[] args) throws Exception {

        Сlassroom classroom = new Сlassroom("Bondarenko A.N.", "Mathematics", 25, "1 course", 40);
        classroom.printName();
        classroom.printInfo();
        System.out.println("\n----------------------------------------------------------");

        LectureRoom lectureRoom = new LectureRoom("Primicheva Z.N.", "Mathematics", 106, "1 course", 2);
        lectureRoom.printName();
        lectureRoom.printInfo();
        System.out.println("\n----------------------------------------------------------");

        ChemicalLaboratory chemicalLaboratory = new ChemicalLaboratory("Rusaya A.V.", "Chemical", 210, "2 course", 250);
        chemicalLaboratory.printName();
        chemicalLaboratory.printInfo();
        System.out.println("\n----------------------------------------------------------");

        ComputerLaboratory computerLaboratory = new ComputerLaboratory("Seleznev S.A.", "APK", 502, "3 course", 30);
        computerLaboratory.printName();
        computerLaboratory.printInfo();
        System.out.println("\n----------------------------------------------------------");
    }
}