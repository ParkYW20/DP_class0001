package hw.ch17;

public class NamePrintObserver implements Observer {

    // 통지 받아서 하는 일: 관찰 대상자로부터 통지가 올 때마다, 관찰 대상자로부터 숫자를 얻어 그 숫자만큼의 자기 이름을 새로운 한 줄에 출력한다
    @Override
    public void update(NumberGenerator generator) {
        // System.out.print("NamePrintObserver:"); 

        int count = generator.getNumber();  // 제너레이터에 어떤 숫자를 생성했는지 얻어온다

        for (int i = 0; i < count; i++) {
            System.out.print("박연우" + " ");   // 그 숫자만큼 자기 이름을 새로운 한 줄에 출력한다
        }
        System.out.println(""); // null string으로 줄만 바꿔준다

        try {
            Thread.sleep(1000); // 1초 쉰다
        } catch (InterruptedException e) {
        }
    }
}
