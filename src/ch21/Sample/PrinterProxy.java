package ch21.Sample;
public class PrinterProxy implements Printable {
    private String name;	// 이름
    private Printer real;	// '본인' 

    // 생성자 
    public PrinterProxy() {
        this.name = "No Name";
        this.real = null;   // 우선 본인이 없는 것으로 설정
    }

    // 생성자(이름 지정)
    public PrinterProxy(String name) {
        this.name = name;
        this.real = null;
    }

    // 이름 설정 
    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) { // 본인이 생성되어 있으면...
            // '본인'에게도 설정한다
            real.setPrinterName(name);
        }
        this.name = name;
    }

    // 이름 취득 
    @Override
    public String getPrinterName() {
        return name;
    }

    // 표시 
    @Override
    public void print(String string) {  // 대리인이 못하는 일
        realize();  // 원본 객체를 생성
        real.print(string); // 원본에게 위임
    }

    // 본인 생성 
    private synchronized void realize() {
        if (real == null) {
            real = new Printer(name);   // 본인이 아직 생성 안 되어 있으면 생성
        }       // 원본인 printer클래스가 코드에 직접 나옴
    }
}
