package hw.ch11;

public class File extends Entry {
    // 속성
    private String name = "";
    private String date = "";
    private int size = 0;
    private String author= "";

    // 생성자 메소드 수정
    public File(String name, String date, int size, String author) {    // 인자: 파일명, 생성날짜, 크기, 작성자
        this.name = name;
        this.date = date;
        this.size = size;
        this.author = author;
    }

    // 메소드
    @Override
    public int getCount() { // '파일이므로 1을 반환하는 메소드' 추가
        return 1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this + " [" + date + "] " + "[" + getCount() + "개] " + "[" + author + "]");
    }
}
