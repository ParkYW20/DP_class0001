package ch11.practice;

// 내용물을 나타냄
public abstract class Entry {
    // 이름을 얻는다
    public abstract String getName();

    // 크기를 얻는다 
    public abstract int getSize();

    // 목록을 표시한다
    public void printList() {   
        printList("");
    }
    // 같은 이름의 메소드인데 타입을 달리 하여 정의하는 경우: 메소드 오버로딩 (오버로드, printList())

    // prefix를 앞에 붙여서 목록을 표시한다 
    protected abstract void printList(String prefix);

    // 문자열 표시 
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
