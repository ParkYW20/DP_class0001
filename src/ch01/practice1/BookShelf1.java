package ch01.practice1;

import java.util.Iterator;

public class BookShelf1 implements Iterable<Book1> {
    private Book1[] books; // 배열 선언
    private int last = 0; // 책의 마지막 위치, 책의 갯수

    public BookShelf1(int maximize) {

    }
    
    // 책을 꽂는 메소드

    // 책을 꺼내오는 메소드

    // 책 갯수를 리턴하는 메소드

    // iterator 반환하는 메소드
    // public BookShelfIterator iterator() {
    @Override
    public Iterator<Book1> iterator() {
        return new BookShelfIterator(this);
        // return new BookShelfIteratorBackward(this);
    }
}
