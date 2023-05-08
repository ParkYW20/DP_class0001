package hw.ch12;

public class MultisideBorder extends Border {
    // 속성
    // private char ch = 'a';    
    private int num = 0;
    private char borderChar = '*';  // 장식 문자. 
            // string과의 차이점: string은 클래스 타입 => 데이터 주소를 저장하는 객체(참조) 변수, 문자열.
            // char는 1개의 문자만을 저장하며 기본형(primitive-type)이므로 변수 그 자체에 값을 저장

    // 생성자: 내용물이 될 display와 장식 문자, 장식 횟수를 지정
    public MultisideBorder(Display display, char ch, int num) {
        super(display);
        this.num = num;
        this.borderChar = ch;
    }

    // 메소드
    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1; // 문자 수는 내용물의 양쪽에 장식 문자만큼 더한 것
    }

    @Override
    public int getRows() {
        return display.getRows(); // 행수는 내용물의 행수와 같다
    }

    @Override
    public String getRowText(int row) { //지정 행의 내용은 내용물의 지정 행 양족에 장식 문자를 붙인 것
        // return borderChar*num + display.getRowText(row) + borderChar*num;  // char형에 저장된 * 을 문자로 인식하지 않고 유니코드(42)로 인식하여 숫자를 반환
        return makeLine(borderChar, num) + display.getRowText(row) + makeLine(borderChar, num);
    }

    private String makeLine(char ch, int num) {   // 문자 ch로 num 수만큼 연속한 문자열을 만든다
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < num; i++) {
            line.append(ch);
        }
        return line.toString();

    }
}
