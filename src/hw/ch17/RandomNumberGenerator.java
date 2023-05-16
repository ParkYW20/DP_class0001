package hw.ch17;

import java.util.Random;

// 구체적인 관찰 대상 (난수를 생성하는 클래스)
public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random(); 	// 난수 생성기 
    private int number;                   	// 현재 수 (이 객체의 상태를 나타냄 : 현재 어떤 숫자가 생성되었는가.)

    // 수를 취득한다 
    @Override
    public int getNumber() {
        return number;
    }

    // 수를 생성한다 
    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);    // (호출할 때마다 임의의 수 생성하는 메소드.) 0~49 사이의 임의의 수 생성 => 상태 변화
            notifyObservers();  // 관찰자에게 통지 ("나 변화했어!")
        }
    }
}
