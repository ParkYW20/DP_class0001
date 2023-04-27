package ch12.Sample;

// 장식자
public abstract class Border extends Display {
    // (속성이) 내용물(장식대상)을 가리킴
    protected Display display;             // 이 장식틀이 감싸는 '내용물'. 부모타입(Display)으로 선언되었으므로 누구든 가리킬 수 있음

    protected Border(Display display) { // 인스턴스 생성 시 '내용물'을 인수로 지정
        this.display = display;
    }
}
