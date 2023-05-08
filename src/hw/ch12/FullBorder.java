package hw.ch12;

// 상하좌우에 장식틀을 붙이는 클래스
public class FullBorder extends Border {
    // 생성자
    public FullBorder(Display display) {
        super(display);
    }

    // 메소드
    @Override
    public int getColumns() {   // 문자 수: 내용물의 문자 수에 좌우 장식 문자만큼을 더함
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {  // 행 수: 내용물의 행수에 상하 장식 문자만큼을 더함
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {     // 상단 테두리
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (row == (display.getRows() + 1)) {        // 하단 테두리
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {        // 기타
            return "|" + display.getRowText(row - 1) + "|";
        }
    }

    // 문자 ch로 count 수만큼 연속한 문자열을 만든다
    private String makeLine(char ch, int count) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < count; i++) {
            line.append(ch);
        }
        return line.toString();
    }
}
