package ch14.Sample;

public abstract class Support {
    // 속성
    private String name;    // 이 트러블 해결자 이름
    private Support next;   // 중요) 떠넘길 곳 (자기 뒷차례. 부모 타입으로 선언됨)

    // 생성자
    public Support(String name) {
        this.name = name;
        this.next = null; // 뒷차례 없다
    }

    // 떠넘길 곳을 설정한다
    public Support setNext(Support next) {
        this.next = next;
        return next; // return이, 인자로 들어온 next가 된다
    }

    // 트러블 해결 절차를 결정한다
    public void support(Trouble trouble) {  // 템플릿 메소드
        if (resolve(trouble)) {  // 내가 해결할 수 있으면...
            done(trouble);
        } else if (next != null) {  // 뒷차례가 있으면...
            next.support(trouble);  // 뒷차례에게 넘긴다
        } else {    // 뒷차례가 없으면 (자기가 마지막이면)...
            fail(trouble);  // 해결 못했다 선언
        }
    }

    // 트러블 해결자의 문자열 표현
    @Override
    public String toString() {
        return "[" + name + "]";
    }

    // 해결하려고 한다
    protected abstract boolean resolve(Trouble trouble);    // 각 해결자들이 자기 방식으로 해결하도록 함

    // 해결했다 
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");  // 해결되었다
    }

    // 해결되지 않았다 
    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");   // 해결하지 못했다
    }
}
