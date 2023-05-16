// 20200207 박연우

package hw.ch17;

public class Main {
    public static void main(String[] args) {
        // 속성 (instance 생성)
        NumberGenerator png = new PrimeNumberGenerator();

        Observer digitObserver = new DigitObserver();
        Observer graphObserver = new GraphObserver();
        Observer namePrintObserver = new NamePrintObserver();

        // 메소드
        System.out.println("[학번] 20200207 [이름] 박연우\n");

        // png에 모든 3종류의 observer들을 등록한다
        png.addObserver(digitObserver);
        png.addObserver(graphObserver);
        png.addObserver(namePrintObserver);

        // png.execute()를 실행한다
        png.execute();

    }
}
