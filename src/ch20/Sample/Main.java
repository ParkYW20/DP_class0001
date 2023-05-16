package ch20.Sample;

public class Main {
    public static void main(String[] args) {    // 명령행 인자

        BigChar bc = new BigChar('1');
        bc.print();

        if (args.length == 0) {     // main에 인자가 전달되었는지 확인하는 방법
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        BigString bs = new BigString(args[0]);  // 인자가 전달이 되었으면 실행됨 
        bs.print();
    }
}
