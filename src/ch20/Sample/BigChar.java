package ch20.Sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    // 문자의 이름 
    private char charname;
    // 큰 문자를 표현하는 문자열('#' '.' '\n'으로 이루어진 열)
    private String fontdata;    // 파일의 내용을 담아 두는 속성

    // 생성자 
    public BigChar(char charname) { // '1'이 들어오면: 해당 파일 이름은 big1.txt
        this.charname = charname;
        try {
            String filename = "big" + charname + ".txt";
            
            StringBuilder sb = new StringBuilder(); // string을 계속 호출할 때 사용하는 클래스
            
            // 파일 내용을 1줄씩 읽어서 스트링빌더에 리스트로 추가(점점 쌓임)
            for (String line: Files.readAllLines(Path.of(filename))) {  // List<String>, 즉 스트링 형으로 반환하여 리스트에 넣어줌
                sb.append(line);
                sb.append("\n");    // 파일 내용이 1줄씩 들어가는데, 줄 바꿈이 없으면 그냥 일렬로 출력해버리게 됨(줄 바꿈 있어야 원래대로 숫자 모양을 출력함)
            }

            this.fontdata = sb.toString();  // 파일 내용이 fontdata에 들어감 (?)
        } catch (IOException e) {   // 파일 다룰 때는 오류가 많이 일어나기 때문에 꼭 try-catch 문 사용하기
            this.fontdata = charname + "?";
        }
    }

    // 큰 문자를 표시한다
    public void print() {
        System.out.print(fontdata);
    }
}
