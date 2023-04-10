package hw.ch05;

import ch04.practice.framework.Factory;
import ch04.practice.framework.Product;
// import ch04.practice.idcard.IDCard;
import ch04.practice.idcard.IDCardFactory;

public class Main1 {
    public static void main(String[] args) {
        // 신분증 직접 생성
        // Product id01 = new IDCard("pyw");    // 패키지 비저블리티 -> 임시로 클래스에 public 붙여야 실행 가능
        // id01.use();


        // 신분증을 공장을 통해 생성
        Factory f = new IDCardFactory();
        Product id02 = f.create("pyw");
        id02.use(); 

    }
}
