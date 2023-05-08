package hw.ch12;

// 좌우에만 장식틀을 붙이는 클래스
public class SideBorder extends Border {
    // 속성
    private char borderChar;    // 장식 문자

    // 생성자
    public SideBorder(Display display, char ch) {
        super(display);
        this.borderChar = ch;  // 문자열 좌우를 장식하는 문자
    }

    // 메소드
    @Override
    public int getColumns() {   // 문자 수: 내용물의 문자 수에 2를 더함
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {  // 행 수: 내용물의 행수와 같음
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {  // 지정 행의 내용은 내용물의 지정 행 양쪽에 장식 문자를 붙인 것
        return borderChar + display.getRowText(row) + borderChar;
    }
}
