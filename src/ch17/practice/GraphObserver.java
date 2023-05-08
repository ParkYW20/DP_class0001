package ch17.practice;

// 
// 관찰한 수를 '간단한 그래프'로 표시함
public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.print("GraphObserver:"); 

        int count = generator.getNumber();  // 제너레이터에 어떤 숫자 생성했는지 얻어옴

        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println(""); // null string으로 줄만 바꿔줌

        try {
            Thread.sleep(1000); // 1초 쉰다
        } catch (InterruptedException e) {
        }
    }
}
