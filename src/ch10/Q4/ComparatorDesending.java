package ch10.Q4;

import java.util.Comparator;

public class ComparatorDesending implements Comparator {

    @Override
    public int compare(Object a, Object b) {
        return ((String) b).compareTo((String) a);
    }
    
}
