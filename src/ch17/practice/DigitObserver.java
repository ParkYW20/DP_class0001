package ch17.practice;

// observer 인터페이스를 구현한 구체적인 관찰자
// 관찰한 수를 '숫자'로 표시함
public class DigitObserver implements Observer {
    // 통지 받아서 하는 일
    @Override
    public void update(NumberGenerator generator) { // 여기서 통지를 받아서 어떻게 하느냐
        System.out.println("DigitObserver:" + generator.getNumber());   // 어떤 숫자를 생성했는지 얻어옴(생성된 숫자가 출력됨)
        try {
            Thread.sleep(1000);  // 찍고 나서 좀 쉰다(1초)
        } catch (InterruptedException e) {
        }
    }
}
