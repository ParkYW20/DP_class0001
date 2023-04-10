package ch01.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        // 책 생성
        Book b1 = new Book( "book1");
        Book b2 = new Book( "book2");

        // System.out.println(b1.getName());
        

        // 책꽂이 생성
        BookShelf bs1 = new BookShelf(10);

        bs1.appendBook(b1);
        // Book result1 = bs1.getBookAt(0);
        // System.out.println(result1.getName());

        bs1.appendBook(b2);
        // Book result2 = bs1.getBookAt(1);
        // System.out.println(result2.getName());

        // for 루프를 이용해서 책이름 출력하기
        for(int i = 0; i < bs1.getLength(); i++) {
            System.out.println(bs1.getBookFrom(i).getName());
        }       // 클라이언트에서 집합체에 직접 접근하는 방식.
                // iterator 사용하지 않았기 때문에 BookShelf.java에서 메소드 명
                // 바꾸면 여기서도 똑같이 bs1.getBookAt() -> getBookfrom() 변경해야 함

        // 확장 for 루프를 이용해서 책이름 출력하기
        for(Book book : bs1) {
            System.out.println(book.getName());
        }       // 이 방법이 그냥 for 루프 보다 편함

        // iterator 를 이용해서 책이름 출력하기
        // iterator 얻기
        System.out.println("<book list using iterator>");
        // BookShelfIterator iterator = bs1.iterator();
        Iterator<Book> iterator = bs1.iterator();
        // iterator 이용해서 원소 얻어오기
        while(iterator.hasNext()) {
            Book b = iterator.next();
            System.out.println(b.getName());
        }

        // 문자열 리스트 다루기
        // 컬렉션: List, Set, Map 
        // ArrayList
        List<String> slist = new ArrayList();   // 부모 타입으로 정의

        slist.add("a");
        slist.add("b");
        slist.add("c"); // 문자열 리스트 완성

        // 모든 원소 출력하기

        // 1. for 루프 이용하기
        for( int i = 0; i < slist.size(); i++ ) {
            System.out.println(slist.get(i));
        }

        // 2. 확장 for 문 이용하기
        for( String s : slist ) {
            System.out.println(s);
        }

        // 3. iterator 이용하기
        // 3.1 iterator 얻기
        Iterator<String> it = slist.iterator();

        // 3.2 원소 얻어오기
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // 4. 스트림 이용하기
        slist.stream().forEach(System.out::println);    // 메소드 참조

    }
}
