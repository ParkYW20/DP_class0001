package ch06.Sample;

import ch06.Sample.framework.Manager;
import ch06.Sample.framework.Product;

public class Main {
    public static void main(String[] args) {
        // 준비 
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('-');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');

        MessageBox box1 = new MessageBox('$');
        box1.use("YeonWoo Park");

        // 등록 
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);
        manager.register("pyw box", box1);

        // 생성과 사용 
        // 클래스 이름 대신 문자열로 객체를 얻음
        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");

        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");

        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");

        Product p4 = manager.create("pyw box");
        p4.use("Duksung University");

        // 1) 클래스 이름 대신 문자열로 객체 생성
        // 2) 클래스 형성 과정이 복잡할 경우, 생성되어 있는 것을 매니저에 등록해놓고 복사하는 것이 효율적

        // 복사 생성자 이용하기 
        Messagebox copy  = new MessageBox(sbox);
        copy.decochar = 
    }

    
}
