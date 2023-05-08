package hw.ch16;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {  // 콜리그 역할도 한다
    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption); // 부모 생성자 호출, 캡션은 부모가 관리함을 알 수 있음
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {  // 지시 받을 때 호출되는 메소드
        setEnabled(enabled);    // Button으로부터 상속 받은 메소드. 지시 받은 대로 활성화/비활성화 결정
    }
}
