package hw.ch14;

public class Main {
    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);
        Support PYW = new PrimeNumberSupport("박연우"); // 추가

        // 학번, 이름
        System.out.println("[학번] 20200207 [이름] 박연우");

        // 사슬 형성 
        PYW.setNext(alice).setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        // alice.setNext(fred).setNext(bob).setNext(charlie).setNext(elmo).setNext(diana);  // 사슬 형태는 언제든지 바꿀 수 있다

        // 다양한 트러블 발생
        for (int i = 1; i <= 100; i += 1) {
            // alice.support(new Trouble(i));
            PYW.support(new Trouble(i));
        }
    }
}
