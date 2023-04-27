package ch05.A3a;


public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {
        System.out.println("인스턴스가 생성되었습니다.");
        slowdown(); // 생성될 때 시간이 걸리게 함
    }

    // public static Singleton getInstance() {
    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    private void slowdown() {
        try {
            Thread.sleep(1000); // CPU를 내놓고 잠을 잔다.
        } catch (InterruptedException e) {
        }
    }
}
