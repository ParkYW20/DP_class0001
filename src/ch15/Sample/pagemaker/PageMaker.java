package ch15.Sample.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
    private PageMaker() {
    }

    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");   // "maildata".txt 파일에 들어있는 properies 데이터를 읽어와서 empty Properties file 변수에 리스트 형태로 저장 
            String username = mailprop.getProperty(mailaddr);   // properties list에서 인자로 들어온 mailaddr와 같은 key를 가진 property를 찾아서 반환(email 넣으면 그 이메일을 키로 가지는 이름 반환. hyuki@example.com=Hiroshi Yuki)
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));   // filename('welcom.html')으로 파일 생성, 'welcom.html'을 (this).writer 속성에 저장한 HtmlWriter 인스턴스(writer)를 생성
            writer.title(username + "'s web page");   // HtmlWriter 인스턴스의 title() 호출: username을 title로 가지는 기본적인 html 페이지 생성
            writer.paragraph("Welcome to " + username + "'s web page!");    // 단락 생성
            writer.paragraph("Nice to meet you!");
            writer.mailto(mailaddr, username);  // email 주소 출력
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
