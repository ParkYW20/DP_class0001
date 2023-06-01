package hw.ch14;

// 소수이면 해결
public class PrimeNumberSupport extends Support {
    // 생성자
    public PrimeNumberSupport(String name) {
        super(name);
    }

    // 메소드
    @Override
    protected boolean resolve(Trouble trouble) {
        if (isPrimeNumber(trouble.getNumber())) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {    // 짝수인 소수는 2가 유일하므로 조건문을 추가한다
            return true;
        }
        if (number % 2 == 0) { // 짝수는 소수가 아니므로 false를 반환한다
            return false;
        }
        for (int i = 3; i < number; i++) { // 홀수 중에서 소수를 검사한다
            if (number % i == 0) {
                return false;
            }
        } 
        return true;
    }
}
