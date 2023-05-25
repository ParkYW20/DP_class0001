package ch15.Sample.pagemaker;

import java.io.Writer;
import java.io.IOException;

// 웹페이지를 만들어주는 (작성하는) 클래스
public class HtmlWriter {
    // 속성
    private Writer writer;  // Writer 변수 만들어줘야 한다

    // 생성자
    public HtmlWriter(Writer writer) {
        this.writer = writer; 
    }

    // 타이틀 출력 (html 앞부분 생성)
    public void title(String title) throws IOException {
        writer.write("<!DOCTYPE html>");
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("\n");
        writer.write("<h1>" + title + "</h1>");   // (화면에 굵은 글씨로 출력됨)
        writer.write("\n");
    }

    // 단락 출력
    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>");
        writer.write("\n");
    }

    // 링크 출력 (hyper link 생성)
    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");  // \" : \를 사용하기 위함

        // paragraph("<a>" + caption + "</a"); // href 가 없으면 이렇게 만들면 됨
    }

    // 이메일 주소 출력 
    public void mailto(String mailaddr, String username) throws IOException {
        link("mailto:" + mailaddr, username);
    }

    // HTML 닫기 
    public void close() throws IOException {
        writer.write("</body>");
        writer.write("</html>");
        writer.write("\n");

        writer.close();
    }
}
