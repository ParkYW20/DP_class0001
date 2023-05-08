package ch12.A2;

public class Main {
    public static void main(String[] args) {
        MultiStringDisplay md = new MultiStringDisplay();   // 여러 층 짜리

        md.add("Hi!");
        md.add("Good morning.");
        md.add("Good night!");
        md.show();
        md.add("학번: 20200207");
        md.add("이름: 박연우");
        md.add("핸드폰 번호: 010-7528-2992");

        Display d1 = new SideBorder(md, '#');   // 내용물을 이걸로 장식
        d1.show();

        Display d2 = new FullBorder(md);
        d2.show();
    }
}
