package ch12.A2;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    // 표시 문자열 저장 장소
    private List<String> body = new ArrayList<>();  // 문자열을 여러 개 가져야 하므로 list 선언
    // 표시 문자열 최대 문자 수 
    private int columns = 0;

    /*
     * 예를 들어 Hi, Good, Morning(7개)
     * 문자열이 ArrayList에 담긴다
     * 최대 문자열이 몇 개인지 기억을 해야 함 (7개)
     * 현재 넣는 문자열이 columns보다 크면 최대 문자 수로 업데이트
     */

    // 문자열 추가 
    public void add(String msg) {
        body.add(msg);

        // 더 긴 문자열을 넣는다면...
        if (columns < msg.length()) {   // columns는 현재까지의 최대 문자열 길이를 기억하는 변수
            // 최대 문자 수 갱신
            columns = msg.length();
        }
        updatePadding();    // 제일 긴 문자열 길이만큼 공백 채워주는 메소드
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size(); // 문자열의 갯수
    }

    @Override
    public String getRowText(int row) {
        return body.get(row);
    }

    // 표시 문자열 오른쪽 끝에 채울 공백을 필요에 따라 늘린다
    private void updatePadding() {
        for (int row = 0; row < body.size(); row++) {
            String line = body.get(row);

            int padding = columns - line.length();  // 채워야 할 빈 칸 개수

            if (padding > 0) {  // 빈 칸을 채워야 하면...
                body.set(row, line + spaces(padding));
            }
        }
    }

    // count 수만큼의 공백을 만든다 
    private String spaces(int count) {
        StringBuilder spaces = new StringBuilder();

        for (int i = 0; i < count; i++) {
            spaces.append(' ');
        }
        
        return spaces.toString();
    }
}
