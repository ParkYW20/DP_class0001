package ch10.A4b;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서
        // 람다식을 이용함
        // Funtional interface: 메소드가 한 개만 선언되어 있는 인터페이스 (메소드가 하나만 있으면 인터페이스 자체를 함수 로 볼 수 있음)
        // Funtional Imterface 들어갈 자리에 람다식을 넣을 수 있다.
        // Comparator 인터페이스 funtional 인터페이스이다.
        list.sort((a, b) -> a.compareTo(b));    // compare 메소드 바디를 제공한 것과 같음 (직접 넣어주는 것임)
        System.out.println(list);

        // 사전식 순으로 큰 순서
        list.sort((a, b) -> b.compareTo(a));
        System.out.println(list);
    }
}
