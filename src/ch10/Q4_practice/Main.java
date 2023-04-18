package ch10.Q4_practice;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 오름차순 정렬
        list.sort( new ComparatorAscending() );
        System.out.println(list);
        
        // 내림차순 정렬
        list.sort( new ComparatorDescending() );
        System.out.println(list);
    }
}