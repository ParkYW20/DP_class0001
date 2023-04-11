package hw.ch05.idcard;

import hw.ch05.framework.Factory;
import hw.ch05.framework.Product;

public class IDCardFactoryYeonWooPark1 extends Factory {

    // 속성
    private int serial = 100;
    
    // 3: Singleton 객체 미리 생성
    private static IDCardFactoryYeonWooPark1 Singleton = new IDCardFactoryYeonWooPark1();   // static: 클래스 만들어질 때 같이 만들어지도록 함
    
    // 1: 생성자를 private으로 한다
    private IDCardFactoryYeonWooPark1() {
        System.out.println("인스턴스가 생성되었습니다.");
    }
    
    // 2: 객체를 얻어가는 메소드를 구현
    public static IDCardFactoryYeonWooPark1 getInstance() {
        return Singleton;
    }


    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override   
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}