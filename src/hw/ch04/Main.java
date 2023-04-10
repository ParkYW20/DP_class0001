package hw.ch04;

import hw.ch04.car.CarFactory;
import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class Main {
    public static void main(String[] args) {

        System.out.println("<< 20200207, 박연우 >>");

        // 1. 4가지 모델명을 가지는 car들을 생산하고, 각각의 use() 호출

        // 1-1. 하나의 인스턴스만 생성하는 방법
        // 4개의 객체 변수가 동일한(하나의) 인스턴스를 가리키므로, use()를 한 데 모아 한꺼번에 실행하면 
        // 명시된 객체 변수명이 다르더라도 마지막에 생성한 객체(car04)의 모델명인 "... 캐스퍼... "만 4번 출력되는 문제가 생김

        Factory f = new CarFactory();

        Product car01 = f.create("박연우");
        // System.out.println(f);   // 인스턴스 주소 비교용 코드
        car01.use();

        Product car02 = f.create("그랜저");
        // System.out.println(f);
        car02.use();     

        Product car03 = f.create("소나타");
        car03.use();     

        Product car04 = f.create("캐스퍼");
        car04.use();     


        // // 1-2. 네 가지 모델명 각각의 Car 인스턴스를 생산하는 방법 

        // Factory f1 = new CarFactory();
        // Factory f2 = new CarFactory();
        // Factory f3 = new CarFactory();
        // Factory f4 = new CarFactory();

        // Product car01 = f1.create("박연우");
        // Product car02 = f2.create("그랜저");
        // Product car03 = f3.create("소나타");
        // Product car04 = f4.create("캐스퍼");

        // car01.use();
        // car02.use();     
        // car03.use();     
        // car04.use();     

        // // 인스턴스 주소 비교
        // System.out.println(f1);   
        // System.out.println(f2);   
        // // 객체 변수는 각각 다른 주소를 참조하지만, 출력시 f4의 모델명만 출력하는 문제가 생김
        // System.out.println(car01);   
        // System.out.println(car02); 
        // // 4개의 Product 객체 전부가 마지막에 생성한 car04 객체의 반환 값을 가짐 (Car_YeonWooPark 클래스의 인스턴스가 car04만을 가리킴)


        // 2. CarFactory의 printAllModelNames()를 호출하여 모든 모델명 출력
        System.out.println("\n<모델명 리스트>");
        CarFactory.printAllModelNames();
    }
}
