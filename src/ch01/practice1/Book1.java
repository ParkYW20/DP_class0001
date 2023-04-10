package ch01.practice1; // 클래스마다 어떤 패키지에 속하는지 선언해줘야 함

public class Book1 {
    // 속성
    private String name = ""; // 책 제목

    // 생성자
    public Book1(String name) {
        this.name = name;
    }

    // 메소드
    public String getName() {
        return name;
    }

}
