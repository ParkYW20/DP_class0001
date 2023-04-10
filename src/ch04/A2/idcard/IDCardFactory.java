package ch04.A2.idcard;


import java.util.Hashtable;

import ch04.A2.framework.Factory;
import ch04.A2.framework.Product;

public class IDCardFactory extends Factory {
    private Hashtable manager = new Hashtable<>();

    private int serial = 100;

    protected synchronized Product createProduct(String owner) {
        manager.put(serial, owner);
        owner = manager.get(serial);

        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
