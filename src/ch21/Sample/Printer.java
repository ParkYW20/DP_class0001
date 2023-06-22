package ch21.Sample;

// 본인: 생성될 때 시간이 오래 걸림
public class Printer implements Printable {
    private String name; // 이름 

    // 생성자 
    public Printer() {
        heavyJob("Printer 인스턴스 생성 중");   // 시간이 오래 걸리는 일
    }

    // 생성자(이름 지정)
    public Printer(String name) {
        this.name = name;
        heavyJob("Printer 인스턴스(" + name + ") 생성 중");
    }

    // 이름 설정 
    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    // 이름 취득 
    @Override
    public String getPrinterName() {
        return name;
    }

    // 이름 붙여서 표시
    @Override
    public void print(String string) {
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }

    // 무거운 작업이라고 가정
    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000); // 1초 간 CPU 내놓고 쉼
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("완료");
    }
}
