package ch04.practice.idcard;

// import java.util.Hashtable;

import ch04.practice.framework.Factory;
import ch04.practice.framework.Product;

public class IDCardFactory extends Factory {
    // private Hashtable manager = new Hashtable<>();

    private int serial = 100;

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override   
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }

    // 중요) 부모 클래스는 추상, 구체적인 메소드 내용은 자신이 구현
    // 부모 클래스(Factory)에서는 구체적으로 어떤 제품을 생성하는지 알 수 없음
}

