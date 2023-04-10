package hw.ch04.car;

import hw.ch04.framework.Product;

public class Car_YeonWooPark extends Product {
    
    // 속성
    private static String modelName;

    // 메소드
    // 모델명을 속성에 저장
    Car_YeonWooPark(String modelName) {
        Car_YeonWooPark.modelName = modelName;
        // getModelName()에 static 붙이면서, 속성의 modelName에도 static 붙이고 'this.~' => 'Car_YeonWooPark.~' 로 바꾸었음
    }

    // 메시지 출력
    @Override
    public void use() {
        System.out.println(this + "인 car를 사용합니다."); // this 는 문자열이 아님 -> 객체의 this.toString()을 호출함
    }

    @Override
    public String toString() {  // Object 클래스로부터 상속
        return "모델명 " + modelName;
    }

    // 자신의 모델명을 반환
    public static String getModelName() {   // Main 클래스에서 CarFactory의 registerProduct()를 호출시 제대로 동작시키기 위해 static 붙임
       return modelName;
    }

}