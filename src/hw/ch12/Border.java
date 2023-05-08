package hw.ch12;

// '장식틀'을 나타내는 추상 클래스
// 장식(Border)이 내용물(Display)과 동일한 메소드를 가진다
// 장식 클래스를 내용물로 해서 또 다른 장식을 붙일 수 있다
public abstract class Border extends Display {
    // 속성
    protected Display display;    // 이 장식틀이 감싸는 '내용물'
        // 중요) 이 필드는 StringDisplay 뿐만 아니라 Border도 참조할 수 있다

    // 생성자
    protected Border(Display display) {    // 인스턴스 생성 시 '내용물'을 인수로 지정
        this.display = display;
    }
}
