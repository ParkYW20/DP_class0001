package ch06.Sample.framework;

import java.util.HashMap;
import java.util.Map;

// 중요) Product 라는 부모 타입으로 코딩이 되어 있음
// 원칙: Programming to Interface/Abstract Class
public class Manager {
    private Map<String,Product> showcase = new HashMap<>();

    public void register(String name, Product prototype) {  // 폴리모르피즘. 입력 인자가 부모 타입(Product)으로 선언 => 메인에서 등록시 upen, mbox 둘 다 가능
        showcase.put(name, prototype);
    }

    public Product create(String prototypeName) {
        Product p = showcase.get(prototypeName);
        // return p; 하지 않고
        return p.createCopy();  // 복제품을 반환함
        // return p.clone();   // 안 된다: clone()은 자기 자신만 호출 가능
    }
}
