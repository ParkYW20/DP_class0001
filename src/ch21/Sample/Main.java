package ch21.Sample;

public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");

        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");  // 대리인이 일함
        p.setPrinterName("Bob");
        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");  // 대리인이 일함
        p.print("Hello, world.");  // 원본 객체를 생성해서 원본에게 위임
    }
}
