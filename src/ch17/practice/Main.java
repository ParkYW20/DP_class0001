package ch17.practice;

public class Main {
    public static void main(String[] args) {
        // 관찰 대상을 생성
        NumberGenerator generator = new RandomNumberGenerator();
        
        // 관찰자를 생성
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();

        // 관찰자를 관찰 대상에 등록
        generator.addObserver(observer1);
        generator.addObserver(observer2);

        // 관찰자에게 숫자 생성을 요청
        generator.execute();    // 숫자생성됨, 생성 시마다 관찰자에게 통지

        // 새로운 observer 만들면, 관찰 대상으로 등록만 하면 됨

    }
}
