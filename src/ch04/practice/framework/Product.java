package ch04.practice.framework;

public abstract class Product {
    // public abstract Product(String name);    
        // 부모 클래스의 생성자는 상속되지 않으므로 이 코드는 의미 없음
    public abstract void use();
        // 모든 제품마다 사용할 때 호출하는 메소드
}
