package ch19.A1;

public interface State {
    public abstract void doClock(Context context, int hour);	// 시간 설정
    public abstract void doUse(Context context);		// 금고 사용 
    public abstract void doAlarm(Context context);		// 비상벨 
    public abstract void doPhone(Context context);		// 일반 통화 

    // doYYY(); 
    // 인터페이스에 새로운 메소드를 추가하면, 모든 상태 클래스들이 이 처리를 구현해야 하므로 새로운 '상태 의존 처리'를 추가하는 것은 어려운 패턴
}
