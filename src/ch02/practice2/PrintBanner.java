package ch02.practice2;

// 어댑터 (위임을 이용함)
public class PrintBanner extends Print {    // 프린트가 추상 클래스여서 인터페이스X, 상속받음
    // 어댑티를 갖는 속성
    private Banner banner; // 220v. 위임? 어댑터가 어댑티를 어떤 속성으로 갖는 것

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    public void printWeak() {  // 12볼트(인터페이스). 여기가 중요. 12 -> 220 볼트
        banner.showWithParen();    // 220볼트 (위임)
            // banner 인스턴스의 showWithParen() 메소드 호출
        
    }

    public void printStrong() {
        banner.showWithAster();
    }

}
