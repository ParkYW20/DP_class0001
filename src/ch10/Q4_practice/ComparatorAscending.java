package ch10.Q4_practice;

import java.util.Comparator;

public class ComparatorAscending implements Comparator<String> {
    
    @Override
    public int compare( String a, String b ) {
        return a.compareTo(b);
        /* a의 문자코드와 b의 문자코드를 비교하여 a가 크면 양수를 리턴
           => a와 b의 위치를 바꿈 (sorting)   */
    }
}
