package ch10.practice;

public class Main {
    public static void main(String[] args) {

    /*
        // 바위
        Hand h1 = Hand.ROCK;
        System.out.println(h1.toString());

        // 가위
        Hand h2 = Hand.getHand(2);
        System.out.println(h2);

        // h1이 h2를 이기는지 확인
        if(h1.isStrongerThan(h2)) {
            System.out.println("h1이 이김");
        } else if ( h1.isWeakerThan(h2)) {   // h2.isWeakerThan(h1)
            System.out.println("h2가 이김");
        } else {
            System.out.println("무승부");
        }
     
        // WinningStrategy 테스트
        WinningStrategy ws1 = new WinningStrategy(100);
        ws1.study(false);
        Hand wsh1 = ws1.nextHand();
        System.out.println(wsh1);

        ws1.study(true);
        wsh1 = ws1.nextHand();
        System.out.println(wsh1);

    */

        // 게임 진행

        // 1. 플레이어 생성
        Player p1 = new Player("박연우", new ProbStrategy(100));
        Player p2 = new Player("박준성", new WinningStrategy(200));

        p2.setStrategy(new ProbStrategy(300));  // 본 패턴의 핵심) 전략을 동적으로 교체함 (실행하면서 바뀌므로 동적)

        // 2. 게임 시작
        for (int i=0; i < 10000; i++) {
            Hand h1 = p1.nextHand();
            Hand h2 = p2.nextHand();

            if ( h1.isStrongerThan(h2)) {
                System.out.println("Winnner: " + p1);
                p1.win();
                p2.lose();
            } else if ( h1.isWeakerThan(h2)) {
                System.out.println("Winnner: " + p2);
                p1.lose();
                p2.win();
            } else {
                System.out.println("Even...");
                p1.even();
                p2.even();
            }
    
        }

        System.out.println("Total Result: ");
        System.out.println(p1);
        System.out.println(p2);

        // 박연우가 더 좋은 전략(ProbStrategy)을 썼기 때문에 더 많이 이김

    }
}
