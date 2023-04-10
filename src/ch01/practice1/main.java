package ch01.practice1;

import java.util.jar.Attributes.Name;

import javax.swing.event.SwingPropertyChangeSupport;

import ch01.practice.BookShelf;

public class main {

    public static void main(String[] args) {
        
        // 책 생성
        Book b1 = new Book(name:"book1");
        System.out.println(b1.getName());
        

        // 책꽂이 생성
        BookShelf

    }

    // for 루프를 이용해서 책이름 출력하기
    for(int i = 0; i < bs1.getLength(); i++) {
        System.out.println(bs1.getBookAt(i).);
    }

    // 확장 for 루프를 이용해서 책이름 출력
    for( Book book : bs1) {
        System.out.println(book.getName());
        
    }

    // iterator 를 이용해서 책이름 출력하기
    // iterator 얻기
    System.out.println(x:"<book list using iterator>");
    // BookShelfIterator iterator = bs1.iterator();
    Iterator<Book> iterator = bs1.iterator();
    // iterator 이용해서 원소 얻어오기
    while( iterator.hasNext()) {
        Book b = iterator.next();
        System.out.println(b.getName());

    }
    // 문자열 리스트 다루기
    // 컬렉션: List, Set(중복된 원소가 없음), Map(키와 밸루 쌍으로 관리해줌)
    // ArrayList
    List<String> slist = new ArrayList();
    slist.add(e:"a");
    slist.add(e:"b");
    slist.add(e:"c");

    // 모든 원소 출력하기
    // 1. for 루프 이용하기
    for( int i = 0; i < slist.size() ; i++) {
        System.out.println(slist.get(i));
    } 

    // 2. 확장 for 문 이용하기
    for( String s : slist)  {
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
    slist.stream().forEach( System.out::println );  // 메소드 참조

}

// NullPointException : 변수가 가리키는 객체가 없음