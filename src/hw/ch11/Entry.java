package hw.ch11;

public abstract class Entry implements Comparable<Entry> {
// public abstract class Entry {
    // 이름을 얻는다
    public abstract String getName();

    // 크기를 얻는다 
    public abstract int getSize();

    // (메소드 추가) 파일 개수를 반환한다
    public abstract int getCount();

    // 목록을 표시한다
    public void printList() {
        printList("");
    }

    // prefix를 앞에 붙여서 목록을 표시한다 
    protected abstract void printList(String prefix);

    // 문자열 표시 
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

    // 객체를 정렬 (경로 명 짧은 순서대로)
    @Override
    public int compareTo(Entry o) {
        // return o.getName().length() - this.getName().length();
        return this.getName().length() - o.getName().length();  // '경로 명' 크기를 비교
    }
}
