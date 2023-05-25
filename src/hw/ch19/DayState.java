package hw.ch19;

public class DayState implements State {
    private static DayState singleton = new DayState();

    private DayState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        // if (hour < 9 || 17 <= hour) {
        if (hour < 9 || 17 <= hour && hour < 20) {  // 20시부터는 '야식 시간'이므로 '야간'을 20시 전까지로 수정
            context.changeState(NightState.getInstance());
        } else if (12 <= hour && hour < 13) {
            context.changeState(NoonState.getInstance());
        } else if (20 <= hour && hour < 24) { // 야식 시간 추가
            context.changeState(NightMealState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("금고 사용(주간)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(주간)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반 통화(주간)");
    }

    @Override
    public String toString() {
        return "[주간]";
    }

    // CCTV 버튼을 눌렀을 때 하는 일
    @Override
    public void doCCTV(Context context) {
        context.recordLog("CCTV: 해상도 600 dpi로 변경");
    }
}
