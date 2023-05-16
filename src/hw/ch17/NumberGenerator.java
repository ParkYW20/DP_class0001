package hw.ch17;

import java.util.ArrayList;
import java.util.List;

// 관찰 대상 (수를 생성하는 추상 클래스)
public abstract class NumberGenerator {
    // Observer를 저장한다  
    private List<Observer> observers = new ArrayList<>();   // 관찰자에게 알려줘야 하므로 관찰자를 속성으로 가짐
                                                            // 관찰자를 모아 관리

    // Observer를 추가한다 
    public void addObserver(Observer observer) {    // 관찰자를 등록하는 일을 함, observer는 부모 타입 => 어떤 종류의 옵저버이든 등록 가능
        observers.add(observer);
    }

    // Observer를 제거한다 
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    // Observer에 통지한다 
    public void notifyObservers() { // 가장 중요!
        // 확장 for문
        for (Observer o: observers) {   // 왼쪽: 원소 꺼내오는 역할 하는 변수 선언. 오른쪽: 원소의 집합
            o.update(this); // 관찰자에게 통지 (다시 듣기 어디서 뭘 받는다고?)
        }
    }

    // 수를 취득한다 
    public abstract int getNumber();

    // 수를 생성한다 
    public abstract void execute();
}
