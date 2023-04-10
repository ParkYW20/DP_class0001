package ch05.practice;

public class Main {
    public static void main(String[] args) {
        Singleton x1 = Singleton.getInstance();
        Singleton x2 = Singleton.getInstance();

        if (x1 == x2) {     // 같은 주소인지 비교함
            System.out.println("x1과 x2는 같은 인스턴스입니다.");
        } else {
            System.out.println("x1과 x2는 다른 인스턴스입니다.");
        }

    }   
}
