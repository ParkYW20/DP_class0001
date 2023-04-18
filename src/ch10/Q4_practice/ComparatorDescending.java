package ch10.Q4_practice;

import java.util.Comparator;

public class ComparatorDescending implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
        return b.compareTo(a);
        /* b의 문자 코드와 a의 문자 코드를 비교
         * 양수가 나오면 b와 a의 위치를 바꿈 */
    }
    
}
