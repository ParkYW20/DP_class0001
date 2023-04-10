package ch05.A1_practice;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");

        int obj1 = TicketMaker.getNextTicketNumber();
        int obj2 = TicketMaker.getNextTicketNumber();

        // Singleton 패턴을 적용하지 않을 경우, 인스턴스를 여러 번 생성
        // 객체 변수는 각각 다른 인스턴스를 가리키게 됨(다른 주소를 참조함)
        if (obj1 == obj2) {
            System.out.println("obj1과 obj2는 같은 인스턴스입니다.");
        } else {
            System.out.println("obj1과 obj2는 같은 인스턴스가 아닙니다.");
        }

        System.out.println(obj1);
        System.out.println(obj2);

        System.out.println("End.");
    }
}
