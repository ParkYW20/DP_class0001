package ch10.Q4;

import java.util.Comparator;

// public class ComparatorAsending implements Comparator {
public class ComparatorAsending implements Comparator<String> {

    @Override
    // 오름차순으로 정렬되도록 반환값을 리턴해야 함
    // public int compare(Object a, Object b) {  // 두 개를 비교함
    public int compare(String a, String b) {    // Comparator<String>으로 원소를 지정하면, String 을 대상으로 함(타입캐스팅 할 필요X)
        // 양수, 음수, 0 (반환값은 이들 중 하나로 결정)
        // 중요) 정렬 주체(List)는 양수가 리턴되면 a와 b의 위치를 서로 바꾼다.
        // 오름차순: 작은 것이 앞에 옴
        // => 큰 게 앞에 오면 양수를 리턴해야 함    (우리는 이것만 하면 됨)
        // return ((String) a).compareTo((String) b);   // 중요) . 이 우선 순위가 가장 높다.
        return a.compareTo(b);   // 중요) . 이 우선 순위가 가장 높다.
        // 'a의 문자코드' - 'b의 문자코드' 
        // => a가 작은 경우에는 음수가 리턴됨 
        // => a가 큰 경우에는 양수가 리턴됨 => a와 b의 위치를 바꾼다.

    }
    
}
