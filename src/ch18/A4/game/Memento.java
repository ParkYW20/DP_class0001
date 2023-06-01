package ch18.A4.game;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Memento {
    private int money;             // 소지금 
    private List<String> fruits;  // 과일

    // 소지금을 얻는다(narrow interface)
    public int getMoney() {
        return money;
    }

    // 생성자(wide interface)
    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

  // 과일을 추가한다(wide interface)
    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    // 과일을 얻는다(wide interface)
    List<String> getFruits() {
        return new ArrayList<>(fruits);
    }

    // 파일에 저장
    public static boolean saveToFile(String filename, Memento memento) {
        StringBuilder sb = new StringBuilder();

        // 소지금
        sb.append(String.format("%d", memento.money));
        sb.append("\n");

        // 과일
        for (String f: memento.getFruits()) {
            sb.append(f);
            sb.append("\n");
        }

        // 쓰기
        try {
            Files.writeString(Path.of(filename), sb,    // Path.of() :경로객체
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    // 파일로부터 생성
    public static Memento loadFromFile(String filename) {
        try {
            // 읽기
            List<String> lines = Files.readAllLines(Path.of(filename)); // 1줄씩 string으로 읽어들여서 list로 만듦
            if (lines.size() == 0) {
                System.out.println("Empty file");
                return null;
            }

            // 소지금
            int money = 0;
            try {
                money = Integer.parseInt(lines.get(0));  // 돈의 액수 string을 정수로 변환
            } catch (NumberFormatException e) {
                System.out.println("Format error: " + e);      // 실패하면 포맷 에러 발생시킴
                return null;
            }

            // 생성
            Memento memento = new Memento(money);

            // 과일
            for (int i = 1; i < lines.size(); i++) {    // index 1부터 과일 저장
                memento.addFruit(lines.get(i));
            }
            return memento;
        } catch (IOException e) {
            System.out.println(e.toString());
            return null;    // null이 return되면 제대로 객체 생성이 안 되었다는 의미
        }
    }
}
