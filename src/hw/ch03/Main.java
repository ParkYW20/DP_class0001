package hw.ch03;

public class Main {
    public static void main(String[] args) {
        
        AbstractDisplay x;

        System.out.println("20200207 박연우");  // 실행 화면 첫 줄에 학번, 이름 출력

        x = new ParkYeonWooDisplay("박연우", "20200207", 4);   // ParkYeonWooDisplay() 객체 생성
        x.display(10);
        // x.display(5);
    }

}
