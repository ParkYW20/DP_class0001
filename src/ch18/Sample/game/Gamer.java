package ch18.Sample.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Originator 역할
public class Gamer {
    // 소지금
    private int money;
    // 과일 
    private List<String> fruits = new ArrayList<>();
    // 난수 생성기 
    private Random random = new Random();

    // 과일 이름 표 
    private static String[] fruitsName = {  // static : class에 속함, array of string
        "사과", "포도", "바나나", "오렌지",
    };

    // 생성자 
    public Gamer(int money) {
        this.money = money;
    }

    // 현재 소지금을 얻는다
    public int getMoney() {
        return money;
    }

    // 내기한다 … 게임 진행 
    public void bet() {     // 게이머가 게임할 때의 동작
        // 주사위를 던진다 
        int dice = random.nextInt(6) + 1;   // 0~5 사이의 정수 발생 + 1 => 1~6
        
        if (dice == 1) {
            // 1의 눈 … 소지금이 증가한다 
            money += 100;
            System.out.println("소지금이 증가했습니다.");
        } else if (dice == 2) {
            // 2의 눈 … 소지금이 절반이 된다 
            money /= 2;
            System.out.println("소지금이 절반으로 줄었습니다.");
        } else if (dice == 6) {
            // 6의 눈 … 과일을 받는다 
            String f = getFruit();
            System.out.println("과일(" + f + ")를 받았습니다.");
            fruits.add(f);
        } else {
            // 그 밖의 눈 … 아무일도 일어나지 않는다 
            System.out.println("변동 사항이 없습니다.");
        }
    }

    // 스냅샷을 찍는다 
    public Memento createMemento() {    // 상태를 보존하는 메소드
        Memento m = new Memento(money);
        
        for (String f: fruits) {
            // 과일은 맛있는 것만 저장한다
            if (f.startsWith("맛있는 ")) {  // 이 문자열로 시작하는 과일만 추가
                m.addFruit(f);
            }
        }
        return m;
    }

    // 복원한다 
    public void restoreMemento(Memento memento) {   // memento를 인자로 받음
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "[money = " + money + ", fruits = " + fruits + "]";
    }

    // 과일을 하나 얻는다
    private String getFruit() {
        String f = fruitsName[random.nextInt(fruitsName.length)];  // 배열의 길이를 이용하여 과일을 선택하여 f에 넣어줌

        if (random.nextBoolean()) {
            return "맛있는 " + f;
        } else {
            return f;
        }
    }
}
