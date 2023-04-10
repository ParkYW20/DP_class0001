package ch01.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// import hw.ch01.BookShelfIteratorBackward;

public class BookShelf implements Iterable<Book> {
    // private Book[] books;   // 배열 선언. 배열일 때는 복수로 지정
    private List<Book> books = new ArrayList<Book>();  // list로 선언, 생성까지 완료

    // int last = 0; // 책의 마지막 위치, 책의 개수

    // public BookShelf(int maxsize) {
    public BookShelf(int initialsize) {
        // 배열 생성
        // this.books = new Book[maxsize];
        
        // list 생성
        this.books = new ArrayList<Book>(initialsize);
    }

    // 책을 꽂는 메소드
    public void appendBook(Book book) {
        // 배열 이용
        // this.books[last] = book;
        // last++;

        // list 이용
        books.add(book);
    }

    // 책을 꺼내오는 메소드
    // public Book getBookAt(int index) {
    public Book getBookFrom(int index) {
        // return books[index];
        return books.get(index);
    }

    // 책 개수를 리턴하는 메소드
    public int getLength() {
        // return last;
        return books.size();
    }

    // iterator 반환하는 메소드
    // public BookShelfIterator iterator() {
    @Override  //어노테이션. 다른 메소드와는 달리 부모의 메소드를 오버라이딩했다 구별 위함
    public Iterator<Book> iterator() {      // 책(Book)을 돌아다니는 iterator
        return new BookShelfIterator(this); // 현재 책꽂이와 iterator가 연결됨
        // return new BookShelfIteratorBackward(this);
    }

}
