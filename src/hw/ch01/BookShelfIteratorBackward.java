// 국어국문학전공 20200207 박연우

package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class BookShelfIteratorBackward implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index;  // 현재 위치를 가리키는 속성 (책꽂이의 몇 번째 책)

    public BookShelfIteratorBackward(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = bookShelf.getLength() -1 ;  // index가 맨끝을 가리키게 됨, -1 해줘야 인덱스와 원소 (개수) 일치
    }

    @Override
    public boolean hasNext() {
        if (index >= 0) {   // 인덱스0까지는 책이 있다고 판단함
            return true;
        } else {
            return false;
        }
    }   

    @Override
    public Book next() {    // next() 에서 책을 한 권 씩 꺼내옴
        if (!hasNext()) {
            throw new NoSuchElementException();  // 컬렉션에서 원소 꺼내올 때 원소가 없으면 발생하는 예외
        }
        Book book = bookShelf.getBookAt(index);
        index--;  // ++을 --로 바꿔줘야 앞으로 감
        return book;
    }    
}
