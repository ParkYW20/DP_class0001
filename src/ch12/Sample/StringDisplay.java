package ch12.Sample;

public class StringDisplay extends Display {
    private String string; // 표시 문자열 

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() {
        return string.length();
    }

    @Override
    public int getRows() {
        return 1; // 행수는 1
    }

    @Override
    public String getRowText(int row) {
        if (row != 0) {     // 0이 아니면 예외 발생 시킴
            throw new IndexOutOfBoundsException();  // 예외 객체 => getRowText 호출한 클라이언트에 예외 떠넘기기
        }
        return string;
    }
}
