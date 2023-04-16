package ch10.practice;

public interface Strategy {
    public abstract Hand nextHand();    // 다음에 내밀 손을 얻기 위해 호출
    public abstract void study(boolean win);    // 다음 승부에 사용될...
}
