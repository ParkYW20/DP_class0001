package ch02.practice1;

// 어댑터 (상속을 이용함)
public class PrintBanner extends Banner implements Print {      // implements Print 가 중요(클라이언트 입장에선 프린트를 구현했다는 게 중요)
    public PrintBanner(String string) {     //생성자
        super(string);      // (생성자 안에서의 super는) 부모 생성자
    }

    @Override
    public void printWeak() {   // 12V
        showWithParen();    // 220V (실제 일은 Banner가 한다)
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
