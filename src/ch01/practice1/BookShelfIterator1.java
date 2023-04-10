package ch01.practice1;

import ch01.practice.BookShelf;
import ch23.A1.turtle.TurtleCanvas;

public class BookShelfIterator1 {
    
    BookShelf bookShelf; // 집합체
    int index;

    // 생성자
    public BookShelfIterator1(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    // 꺼내올 책이 더 있는지 검사하는 메소드 : 모든 iterator가 제공
    public boolean hasNext() {
        if( index < this.bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
        }
    }

    // 다음 책을 반환하는 메소드
    public Book next() {
        Book book = this.bookShelf.getBookAt(index);
        index++;
        return book;

    }

}
