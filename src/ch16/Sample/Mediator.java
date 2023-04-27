package ch16.Sample;

public interface Mediator {
    // Colleague를 생성한다 
    public abstract void createColleagues();

    // Colleage의 상태가 변화했을 때 호출된다 (중요! 보고 받을 때)
    public abstract void colleagueChanged();
}
