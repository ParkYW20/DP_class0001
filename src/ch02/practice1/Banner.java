package ch02.practice1;

// vendor class (이미 제공되는 것, 220V)
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");     // string 출력
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");     // string 출력력
    }
}
