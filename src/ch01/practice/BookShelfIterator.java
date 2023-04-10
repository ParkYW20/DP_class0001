package ch01.practice;

import java.util.Iterator;

// next() 가 중요
public class BookShelfIterator implements Iterator<Book> {    

    BookShelf bookShelf; // 집합체 
    int index = 0;

    // 생성자
    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;  // 코드 채울 수 있어야 함
        this.index = 0;
    }

    // 꺼내올 책이 더 있는지 검사하는 메소드 (모든 iterator가 제공)
    public boolean hasNext() {
        if(index < this.bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    // 다음 책을 반환하는 메소드
    @Override
    public Book next() {
        Book book = this.bookShelf.getBookFrom(index);
        index++;
        return book;
    }
}
