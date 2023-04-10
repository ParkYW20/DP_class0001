// 국어국문학전공 20200207 박연우

package hw.ch01;

public class Book {
    private String name;
    private String author;  // author 속성 추가


    public Book(String name, String author) {  // String author 인자로 넘겨 받도록 함
        this.name = name;
        this.author = author;                  // author 객체 생성
    }

    public String getName() {
        return name;
    }
    
    public String getAuthor() {   // 저자를 얻어오는 메소드 추가
        return author;            // 메소드 호출시 author 객체를 반환
    }
}
