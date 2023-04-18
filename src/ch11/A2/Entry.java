package ch11.A2;

public abstract class Entry {
    private Entry parent;

    // 부모를 설정한다
    protected void setParent(Entry parent) {
        this.parent = parent;
    }

    // 이름을 가져온다 
    public abstract String getName();

    // 크기를 가져온다 
    public abstract int getSize();

    // 목록을 표시한다 
    public void printList() {
        printList("");
    }

    // prefix를 앞에 붙여 목록을 표시한다
    protected abstract void printList(String prefix);

    // 문자열 표시
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

    // 전체 경로를 가져온다 
    public String getFullName() {
        StringBuilder fullname = new StringBuilder();   // 문자열 구축을 위한 객체

        Entry entry = this; // 현재 객체를 entry가 가리키게 함

        do {
            fullname.insert(0, entry.getName());    // 현재 객체의 이름을 맨 앞에 삽입함
            fullname.insert(0, "/");
            // entry 변수는 현재 노드를 가리킨다
            entry = entry.parent;   // 현재 위치(포인터)를 부모로 옮긴다
        } while (entry != null);    // 부모가 더이상 없으면 루프를 빠져나옴

        return fullname.toString(); // 최종 문자열을 얻음
    
    }
}
