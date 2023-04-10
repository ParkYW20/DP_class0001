package ch05.A3a;

// Main 클래스가 스레드 클래스임 (Thread클래스를 상속 받았기 때문)
public class Main extends Thread {
    public static void main(String[] args) {
        System.out.println("Start.");

        // 스레드 객체가 3개 생성됨
        new Main("A").start();  // 시작해라!
        new Main("B").start();  // 시작해라!
        new Main("C").start();  // 시작해라!

        System.out.println("End.");
    }

    @Override
    // run() 에는 이 Thread 클래스가 하는 일이 담김 (getInstance() 호출)
    public void run() {
        Singleton obj = Singleton.getInstance(); 
        System.out.println(getName() + ": obj = " + obj);   // obj에는 주소가 담김
    }

    public Main(String name) {
        super(name);
    }
}
