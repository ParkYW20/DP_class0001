package hw.ch12;

// 문자열 표시용 추상 클래스
// 중심 컴포넌트와 장식자를 동일하게 보이게 함 (내용물을 나타냄)
public abstract class Display {
    // abstract 메소드
    public abstract int getColumns();   // 가로의 문자 수를 얻기 위한 메소드
    public abstract int getRows();  // 세로 줄(행)의 개수를 얻기 위한 메소드
    public abstract String getRowText(int row);    // 지정한 줄(row행)의 문자열을 얻기 위한 메소드

    // 모든 행을 표시한다
    public void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
    // Template Method 패턴이 적용됨
}
