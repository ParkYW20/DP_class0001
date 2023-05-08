package ch16.Sample;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
    private Mediator mediator;

    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
        super(caption, group, state);
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    // Event Listener
    // GUI 컴포넌트에 사용자 액션이 일어나면 이벤트가 발생한다. 이벤트가 발생하면, 등록되어 있던 이벤트 리스너의 메소드가 실행된다.
    // > Item Listener : item 이벤트 발생 -> itemListener의 itemStateChanged(ItemEvent e) 메소드 실행
    @Override 
    public void itemStateChanged(ItemEvent e) { // itemListener 인터페이스 구현
        // 상태가 변화하면 Mediator에 알린다
        mediator.colleagueChanged();
    }
    // 콜리그들은 상태가 변화할 때마다(이벤트 발생할 때마다) 중재자에 알림
}
