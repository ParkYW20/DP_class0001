package hw.ch05.idcard;

import ch04.practice.framework.Factory;
import ch04.practice.framework.Product;

public class IDCardFactoryYeonWooPark2 extends Factory {

    private static IDCardFactoryYeonWooPark2 singleton = null;  // Singleton => IDCardFactoryYeonWooPark2 (수정)

    private IDCardFactoryYeonWooPark2() {   // Singleton => IDCardFactoryYeonWooPark2
        System.out.println("인스턴스를 생성했습니다.");
        slowdown();
    }

    public static synchronized IDCardFactoryYeonWooPark2 getInstance() {   // Singleton => IDCardFactoryYeonWooPark2 (수정)
        if (singleton == null) {
            singleton = new IDCardFactoryYeonWooPark2();    // Singleton => IDCardFactoryYeonWooPark2 (수정)
        }
        return singleton;
    }

    private void slowdown() {
        try {
            Thread.sleep(1000); // 1000 =>  (객체 생성시 3초가 걸리도록)
        } catch (InterruptedException e) {
        }
    }

}

