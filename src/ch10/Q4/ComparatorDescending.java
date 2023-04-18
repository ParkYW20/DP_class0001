package ch10.Q4;

import java.util.Comparator;

public class ComparatorDescending implements Comparator {

    @Override
    public int compare(Object a, Object b) {
        return ((String) b).compareTo((String) a);
        /*
         * Comparator의 원소 타입을 <String>으로 지정하지 않았기에
         * method 구현 시 (String)을 명시하여 강제 타입 변환
         */
    }
    
}
