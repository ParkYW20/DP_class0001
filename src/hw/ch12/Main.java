package hw.ch12;

// 동작 테스트용 클래스
public class Main {
    public static void main(String[] args) {
        System.out.println("[학번] 20200207 [이름] 박연우\n");

        MultiStringDisplay md = new MultiStringDisplay();

        // md.add("학번: 20200207");
        // md.add("이름: 박연우");
        // md.add("핸드폰 번호: 010-7528-2992");
        md.add("hi");
        md.add("hello!");
        md.add("nice to meet you!");

        Display d1 = new SideBorder(md, '%');
        Display d2 = new FullBorder(d1);
        Display d3 = new UpDownBorder(d2, '=');
        Display d4 = new MultisideBorder(d3, '*', 3);
        d4.show();

    }
}
