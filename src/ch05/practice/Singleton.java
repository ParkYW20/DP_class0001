package ch05.practice;

// 싱글턴 패턴을 적용
public class Singleton {
    // 3: Singleton 객체 미리 생성
    private static Singleton singleton = new Singleton();   // static: 클래스 만들어질 때 같이 만들어지도록 함

    // 1: 생성자를 private으로 한다
    private Singleton() {
        // 생성될 때 하는 일
        System.out.println("인스턴스가 생성되었습니다.");
    }

    // 2: 객체를 얻어가는 메소드를 구현
    public static Singleton getInstance() {     // static 변수는 static이어야 접근 가능(?)
        return singleton;
    }
}


//enum Month {
//    January, Feburary, March, April, May;
//}
// Month.January;