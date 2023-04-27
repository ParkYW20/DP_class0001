package ch12.Sample;

public class SideBorder extends Border {    // 내용물 양쪽에 캐릭터 붙이는 애
    private char borderChar;  // 장식 문자

    // 내용물이 될 Display와 장식 문자를 지정
    public SideBorder(Display display, char ch) {   
        super(display);
        this.borderChar = ch;
    }

    @Override
    public int getColumns() {
        // 문자 수는 내용물의 양쪽에 장식 문자만큼 더한 것
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        // 행수는 내용물의 행수와 같다 
        return display.getRows();
    }

    @Override
    public String getRowText(int row) { // 실제 뭘 출력할지를 return
        // 지정 행의 내용은 내용물의 지정 행 양쪽에 장식 문자를 붙인 것
        return borderChar + display.getRowText(row) + borderChar;
    }
}
