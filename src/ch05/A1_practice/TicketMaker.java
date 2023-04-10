package ch05.A1_practice;

public class TicketMaker {
    private static int ticket = 1000;

    public static int getNextTicketNumber() {
        return ticket++;    
        // ++이 뒤에 있음 => ticket 초기값을 먼저 실행, 이후 변수에 ++된 값을 저장
    }
    // 왜 static을 붙여야 Main 클래스에서 잘 작동하지?

}
