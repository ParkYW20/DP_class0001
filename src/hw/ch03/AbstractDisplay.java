// 20200207 박연우
package hw.ch03;

public abstract class AbstractDisplay {
    // open, print, close는 하위 클래스에 구현을 맡기는 추상 메소드 
    // 메소드 선언
    public abstract void open();
    public abstract void print();
    public abstract void close();

    // display는 AbstractDisplay에서 구현하는 메소드 
    public final void display(int times) {   // 메소드 프로토타입 수정
 
        open();
        for (int i = 0; i < times; i++) {   // print()를 times 횟수 만큼 호출하도록 for 루프 수정
            print();
        }
        close();
    }
}
