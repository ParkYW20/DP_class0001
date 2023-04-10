package hw.ch02;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("20200207 박연우");

        FileIO f = new FileProperties();
        try {
            f.readFromFile("file.txt");

            // 새로 쓰여지는 내용
            f.setValue("Year", "2023");
            f.setValue("bornYear", "2002");
            f.setValue("StudentID", "20200207");
            f.setValue("Name", "Park YeonWoo");
            f.setValue("Location", "Anyang-si");

            f.writeToFile("ParkYeonWoo.txt");   // newfile.txt -> (이름).txt 로 수정함
            System.out.println("newfile.txt is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
