package ch15.Sample;

import ch15.Sample.pagemaker.PageMaker;

public class Main {
    public static void main(String[] args) {
        // 퍼사드를 이용 (PageMaker가 퍼사드임)
        // PageMaker.makeWelcomePage("hyuki@example.com", "welcome.html");
        // PageMaker.makeWelcomePage("motheryourstar@duksung.ac.kr", "welcome2.html");
        PageMaker.makeWelcomePage("gildong@example.com", "welcome3.html");
    }
}
