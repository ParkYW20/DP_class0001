package hw.ch16;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Mediator mediator;  // 자기 중재자를 가지고 있음

    public ColleagueTextField(String text, int columns) {
        super(text, columns);
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;   // 메디에이터를 받아서 속성에 담아둠
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);    // textfield에서 상속받은 메소드
        // 활성/비활성에 맞게 배경색을 변경한다
        setBackground(enabled ? Color.white : Color.lightGray); // 1st인자 참이면 2nd인자 실행, 거짓이면 3rd인자 실행
    }

    @Override
    public void textValueChanged(TextEvent e) {
        // 문자열이 변화했으면 Mediator에 알린다
        mediator.colleagueChanged();    // 중재자한테 통지가 가는 것을 알 수 있음
    }
}
