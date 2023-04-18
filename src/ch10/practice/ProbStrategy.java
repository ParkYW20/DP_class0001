package ch10.practice;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;
    
    // 2차원 배열 ( 인덱스('[]')가 2개씩 )
    private int[][] history = {
        { 1, 1, 1, },
        { 1, 1, 1, },
        { 1, 1, 1, },
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue)); // 현재 나온 숫자
        int handvalue = 0;

        if (bet < history[currentHandValue][0]) {   // 첫번째 구간 (주먹 내고 0): 0을 대입
            handvalue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) { // 두번째 구간: 1
            handvalue = 1;
        } else {    // 세번째 구간: 2
            handvalue = 2;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;
        return Hand.getHand(handvalue);
    }

    private int getSum(int handvalue) {     // handvalue는 몇 번 행을 더할 것이냐
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[handvalue][i];   // handvalue 행을 다 더함. handvalue는 고정, i (컬럼 번호)가 바뀜
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {  // 이겼으면 (T)
            history[prevHandValue][currentHandValue]++;
        } else {    // 졌으면 (F)
            history[prevHandValue][(currentHandValue + 1) % 3]++;   // current~ 가 아닌 값 % 3
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
