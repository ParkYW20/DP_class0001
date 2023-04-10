package hw.ch04.car;

import java.util.Iterator;
import java.util.Vector;
import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class CarFactory extends Factory {
    
    // 속성
    private static Vector<String> modelNames = new Vector<String>();  // 생산된 제품들의 모델명들을 저장하는 컬렉션 객체 변수

    // 메소드
    // 입력된 모델명의 car를 생성해서 반환
    @Override
    protected Product createProduct(String modelName) {
        return new Car_YeonWooPark(modelName);
    }

    // 입력 인자인 product의 모델명을 modelNames에 추가
    @Override   
    protected void registerProduct(Product product) {
        modelNames.add(Car_YeonWooPark.getModelName());
    }

    // modelNames에 저장되어 있는 모델 이름들을 하나씩 출력
    public static void printAllModelNames() {   // Main 클래스에서 호출하기 위해 static 붙임

        // iterator 선언 및 얻기
        Iterator<String> it = modelNames.iterator();

        // 원소 얻어오기
        while(it.hasNext()) {
            System.out.println(it.next());
        }    
    }
}
