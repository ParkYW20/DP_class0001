package ch02.practice1;

// 클라이언트
public class Main {
    public static void main(String[] args) {

        // 가정: 클라이언트가 직접 Banner를 사용하지 못한다
        // Banner b = new Banner("박연우");
        // b.showWithParen();
        // b.showWithAster();

        // 클라이언트는 Print 인터페이스를 이용하기를 원한다
        // why? 해당 인터페이스로 다른 클라이언트들이 이미 작업을 해놓은 경우 등
        // 이용하는 쪽에서는 Print 인터페이스를 이용하지만
        // 실제 일은 위 Banner 클래스가 하도록 하기 위한 코드
        Print x = new PrintBanner("박연우");
        x.printWeak();
        x.printStrong();
    }
}
