package hw.ch15.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
    // 생성자
    private PageMaker() {
    }

    // 메소드
    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title(username + "'s web page");
            writer.paragraph("Welcome to " + username + "'s web page!");
            writer.paragraph("Nice to meet you!");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(String filename) {
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));   // write 할 수 있는 file 생성, 해당 파일에 html 기본 틀 작성한 HtmlWriter 객체 생성 
            writer.title("Link page");
            Properties mailprop = Database.getProperties("maildata");   // 'maildata'.txt 파일에서 properties 데이터 읽어와 empty properties 파일에 저장 후 Properties 변수('mailprop')에 할당
            for (String mailaddr: mailprop.stringPropertyNames()) {     // 확장 for문(iterator pattern): mailaddr 원소가, mailprop 파일에서 key값만 걸러낸 instance를 차례로 돌아다니며
                String username = mailprop.getProperty(mailaddr, "(unknown)");  // mailaddr 값과 같은 key를 가진 value를 반환하여 변수 username에 저장
                writer.mailto(mailaddr, username);  // link로 된 e-mail address 출력 
            }   // => iterator가 돌아다니며 한 줄씩 출력
            writer.close();
            System.out.println(filename + " is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeUrlPage(String urlFileName) {
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(urlFileName)); // 클라이언트가 makeUrlPage("urlPage.html")이라고 호출하면 "urlPage.html" 파일이 생성됨
            writer.title("url Page");  // html 문서의 title로 'url page'가 들어감
            Properties urlprop = Database.getProperties("urldata");   // 'urldata'.txt 파일에서 properties 데이터 읽어와 empty properties 파일에 저장 후 Properties 변수('urlprop')에 할당
            for (String siteName: urlprop.stringPropertyNames()) {   // 확장 for문: siteName 원소가, urlprop 파일에서 key값만 걸러낸 instance를 차례로 돌아다니며
                String url = urlprop.getProperty(siteName, "(unknown)");  // siteName을 key로 가지는 property의 value를 반환하여 변수 url에 저장
                writer.link(url, siteName);  // <P> 태그로 감싸진, link로 된 url 출력 
            }   // => iterator가 돌아다니며 한 줄씩 출력
            writer.close();
            System.out.println(urlFileName + " is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
