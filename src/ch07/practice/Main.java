package ch07.practice;

public class Main {
    public static void main(String[] args) {


        // textBuilder 를 이용
        TextBuilder tb = new TextBuilder();
        Director d1 = new Director(tb);   // 구체적인 빌더를 외부에서 주입함 **의존성 주입(Denpendency Injection)
                                        // => 어떤 일을 결정할 때 외부에서 결정할 수 있다
        d1.construct();  // 문서 구축됨
        String result = tb.getTextResult();
        System.out.println(result);

        // HTMLBuilder 를 이용
        HTMLBuilder hb = new HTMLBuilder();
        Director d2 = new Director(hb);
        d2.construct();  // 문서 구축됨
        String filename = hb.getHTMLResult();
        System.out.println("HTML 파일" + filename + " 이 작성되었습니다.");


    }
}
