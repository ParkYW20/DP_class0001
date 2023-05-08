package ch17.A1;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int number;	// 현재 수 
    private int end;		// 종룟값(이 값은 포함하지 않는다)
    private int inc;		// 증갓값 

    public IncrementalNumberGenerator(int start, int end, int inc) {
        this.number = start;    // number부터 시작하니까 초기값으로 start 주는 것임
        this.end = end;
        this.inc = inc;
    }

    // 수를 취득한다 
    @Override
    public int getNumber() {
        return number;
    }

    // 수를 생성한다 
    @Override
    public void execute() {
        while (number < end) {
            notifyObservers();  // 관찰자들에게 통지
            number += inc;  // 반복할 때마다 증가된 숫자가 통지될 것임
        }
    }
}
