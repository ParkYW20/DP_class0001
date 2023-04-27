package hw.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry{
    // 속성
    private String name = "";
    private String date = "";
    private String author = "";
    private List<Entry> directory = new ArrayList<>();   // 자기 내용물 리스트를 관리하는 변수

    // 생성자
    public Directory(String name, String date, String author) { // 인자: 파일명, 생성날짜, 작성자
        this.name = name;
        this.date = date;
        this.author = author;
    }

    // 메소드
    @Override
    public int getCount() { // 자기 아래에 존재하는 모든 파일의 개수를 얻어 반환
        int count = 0;
        for (Entry file: directory) {   // directory 컬렉션의 file 변수 (부모 타입으로 선언)
            count += file.getCount();   // File 객체가 있을 경우 +1 (File 클래스의 getCount() 호출)
        }
        return count;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry: directory) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        // directory.sort( (a, b) -> a.compareTo(b));

        System.out.println(prefix + "/" + this + " [" + date + "] " + "[" + getCount() + "개] " + "[" + author + "]");
        // for (Entry entry: directory) {
        //     entry.printList(prefix + "/" + name);
        // }
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    // 디렉터리 엔트리를 디렉터리에 추가한다
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

}
