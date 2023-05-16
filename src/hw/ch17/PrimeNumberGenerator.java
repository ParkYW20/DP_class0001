package hw.ch17;

import java.util.Random;

public class PrimeNumberGenerator extends NumberGenerator {
    // 속성
    private Random random = new Random(); 	// 난수 생성기 
    private int number;                   	// 현재 수 (이 객체의 상태를 나타냄 : 현재 어떤 숫자가 생성되었는가.)

    // 메소드
    // 수를 취득한다 
    @Override
    public int getNumber() {
        return number;
    }

    // 수를 생성한다 
    @Override
    public void execute() {
        for (int i = 0; i < 100; i++) {             // 100개의 숫자를 생성한다
            number = 1 + random.nextInt(101); // 1~100 사이의 임의의 수를 생성한다 => 상태 변화
            
            if (isPrimeNumber(number)) { // 생성된 숫자가 소수일 때만 관찰자에게 통지한다
                notifyObservers();       // 관찰자에게 통지
            }
        }
    }

    // 인자로 들어온 정수가 소수인지 검사한다
    private boolean isPrimeNumber(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {    // 짝수인 소수는 2가 유일하므로 시간을 줄이기 위해 조건문을 추가한다
            return true;
        }
        if (num % 2 == 0) { // 짝수는 소수가 아니므로 false를 반환한다
            return false;
        }
        for (int i = 2; i * i <= num; i += 2) { // 홀수를 검사한다
            if (num % i == 0) {
                return false;
            }
        } 
        return true;
    }

}
