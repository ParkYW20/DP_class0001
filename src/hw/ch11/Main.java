package hw.ch11;

public class Main {
    public static void main(String[] args) {
        System.out.println(" 학번 20200207, 이름 박연우 ");

        // directory 생성
        Directory myDocuments_dir = new Directory("MyDocuments", "20230401", "YeonWooPark");
        Directory myData_dir = new Directory("MyData", "20230401", "YeonWooPark");
        Directory myPictures_dir = new Directory("MyPictures", "20230401", "YeonWooPark");
        myDocuments_dir.add(myData_dir);
        myData_dir.add(myPictures_dir);

        // file 생성
        myDocuments_dir.add(new File("박연우0.doc", "20230501", 1000, "YeonWooPark"));
        myData_dir.add(new File("박연우1.doc", "20230501", 2000, "YeonWooPark"));
        myData_dir.add(new File("박연우2.java", "20230501", 3000, "YeonWooPark"));
        myPictures_dir.add(new File("박연우3.gif", "20230601", 4000, "YeonWooPark"));
        myPictures_dir.add(new File("박연우4.jpg", "20230601", 5000, "YeonWooPark"));
        myPictures_dir.add(new File("박연우5.png", "20230601", 6000, "YeonWooPark"));

        myDocuments_dir.printList( );
    }
}
