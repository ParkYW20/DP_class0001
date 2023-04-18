package ch10.Q4;

import java.util.*;

class Main {
    public static void main(String[] args) {
        // 키워드 기억해두기
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // sorting 두 번 요청
        // list: 전략을 가지는 컨텍스트
        /* comparator: 전략에 해당됨 
           (What strategies do we choose to sort) */

        // 사전순으로 작은 순서(오름차순)
        list.sort( new ComparatorAscending() );
        System.out.println(list);

        // 사전순으로 큰 순서 (내림차순)
        list.sort( new ComparatorDescending() );
        System.out.println(list);
    }
}
