package hw.ch19;

// 야식 시간 (20:00-24:00)
public class NightMealState implements State {
    // 속성
    private static NightMealState singleton = new NightMealState();

    // 생성자
    private NightMealState() {
    }

    // 메소드
    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || 17 <= hour && hour < 20) {  // 야간
            context.changeState(NightState.getInstance());
        } else if (12 <= hour && hour < 13) {   // 점심 시간
            context.changeState(NoonState.getInstance());
        } else if (9 <= hour && hour < 17) {    // 주간
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("비상：야식 시간에 금고 사용！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(야식 시간)");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("야식 시간 통화 녹음");
    }

    @Override
    public String toString() {
        return "[야식 시간]";
    }

    // CCTV 버튼을 눌렀을 때 하는 일
    @Override
    public void doCCTV(Context context) {
        context.recordLog("CCTV: Off");
    }
}
