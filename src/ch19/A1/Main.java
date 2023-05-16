package ch19.A1;

public class Main {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("State Sample");
        while (true) {  // 무한 루프
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);   // 시간 설정 
                try {
                    Thread.sleep(1000); // 1번 알려주고 나서 1초 쉼 (1시간을 1초로 구현했다)
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
