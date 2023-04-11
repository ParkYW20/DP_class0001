package hw.ch05;

import hw.ch05.idcard.IDCardFactoryYeonWooPark1;

public class Main1 {
    // 
    public static void main(String[] args) {
    
        System.out.println("20200207 박연우");

        // getInstace()를 두 번 호출, factory1과 factory2가 가리키도록 함
        // Factory f = new IDCardFactoryYeonWooPark1();
        IDCardFactoryYeonWooPark1 factory1 = IDCardFactoryYeonWooPark1.getInstance();
        IDCardFactoryYeonWooPark1 factory2 = IDCardFactoryYeonWooPark1.getInstance();

        // 두 변수가 동일한 객체를 가리키는지 테스트
        if (factory1 == factory2) {     
            System.out.println("factory1과 factory2는 같은 인스턴스입니다.");
        } else {
            System.out.println("factory1과 factory2는 다른 인스턴스입니다.");
        }

    }
}