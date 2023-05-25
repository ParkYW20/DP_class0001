package hw.ch19;

public class Main {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("State Sample [학번]20200207 [이름]박연우");
        while (true) {
            // for (int hour = 0; hour < 24; hour++) {
            for (int hour = 15; hour < 24; hour++) {    // 최초 시간을 15:00 로 변경함, 15:00 - 24:00가 반복됨
                frame.setClock(hour);   // 시간 설정
                try {
                    Thread.sleep(2000); // 1000 => 2000 으로 변경하였음 (2초당 1시간이 흘러간다)
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
