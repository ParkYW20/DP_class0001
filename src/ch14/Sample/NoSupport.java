package ch14.Sample;

public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);    // 부모 생성자 호출
    }

    @Override
    protected boolean resolve(Trouble trouble) {        // 왜 protected 로 설정했을까? -외부에서 접근 못하도록! 
        return false; // 자신은 아무것도 해결하지 않는다
    }
}
