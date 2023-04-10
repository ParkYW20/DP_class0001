// 국어국문학전공 20200207 박연우

package hw.ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    public Iterator<Book> iteratorBackward() {
        return new BookShelfIteratorBackward(this);
    }

    // @Override
    // public Iterator<Book> iterator() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    @Override
    public Iterator<Book> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
}
