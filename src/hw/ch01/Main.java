// 국어국문학전공 20200207 박연우

package hw.ch01;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(6);
        bookShelf.appendBook(new Book("자료구조론", "박우창"));
        bookShelf.appendBook(new Book("소프트웨어분석설계", "최승훈"));
        bookShelf.appendBook(new Book("프로그래머수학", "이주영"));
        bookShelf.appendBook(new Book("컴퓨터동작원리", "유견아"));
        bookShelf.appendBook(new Book("컴퓨터그래픽스", "이경미"));
        bookShelf.appendBook(new Book("<<용비어천가>>(세종 29년(1447))", "박연우"));

        System.out.println("\n20200207 박연우\n");


        // 명시적으로 Iterator를 사용하는 방법 
        // Iterator<Book> it = bookShelf.iterator();
        Iterator<Book> it = bookShelf.iteratorBackward();

        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName() + ", " + book.getAuthor());
        }
        System.out.println();

    }
}
