package ch12.A1;

public class StringDisplay extends Display {
    private String string; // 표시 문자열
        // private => 같은 class 내에서만 접근 가능. 왜 여기서 private 붙이나?

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() {   // 왜 인자가 없는데도 에러가 안 나지?
        return string.length();
    }

    @Override
    public int getRows() {
        return 1; // 행수는 1
    }

    @Override
    public String getRowText(int row) {
        if (row != 0) {
            throw new IndexOutOfBoundsException();
        }
        return string;
    }
}
