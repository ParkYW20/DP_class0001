package hw.ch05.idcard;

import hw.ch05.framework.Factory;
import hw.ch05.framework.Product;

public class IDCardFactoryYeonWooPark2 extends Factory {
    
    // 속성
    private int serial = 100;
    private static IDCardFactoryYeonWooPark2 singleton = null;  // 객체가 생성되지 않게끔 하는 키워드

    private IDCardFactoryYeonWooPark2() {   
        System.out.println("인스턴스를 생성합니다.");
        slowdown(); // 생성될 때 시간이 걸리게 함
    }

    public static synchronized IDCardFactoryYeonWooPark2 getInstance() {   
        if (singleton == null) {
            singleton = new IDCardFactoryYeonWooPark2();
        }
        return singleton;
    }

    private void slowdown() {
        try {
            Thread.sleep(3000); // 객체 생성시 3초가 걸리도록 함
        } catch (InterruptedException e) {
        }
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

