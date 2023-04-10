package hw.ch04.framework;

public abstract class Factory {
    // 제품 생산 시 진행하는 큰 흐름 (=> 템플릿 메소드)
    public final Product create(String modelName) {    // 제품 생산하는 메소드
        Product p = createProduct(modelName);
        registerProduct(p);
        return p;
    }

    // 실제로 어떤 제품(객체)를 생성할 지는 자식에게 맡긴다.
    protected abstract Product createProduct(String modelName);
    protected abstract void registerProduct(Product product);
}
