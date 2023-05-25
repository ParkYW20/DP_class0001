package ch19.Sample;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Context {
// public class SafeFrame extends Frame implements Context {
    private TextField textClock = new TextField(60);		// 현재 시간 표시
    private TextArea textScreen = new TextArea(10, 60);	// 경비 센터 출력
    private Button buttonUse = new Button("Use Safe");	// 금고 사용 버튼
    private Button buttonAlarm = new Button("Emergency Bell");	// 비상벨 버튼
    private Button buttonPhone = new Button("General Call");	// 일반 통화 버튼
    private Button buttonExit = new Button("Exit");		// 종료 버튼

    private State state = DayState.getInstance();  // 현재 상태를 가짐 (부모 타입으로 선언됨)

    // 생성자 
    public SafeFrame(String title) {
        super(title);

        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        
        // textClock 배치 
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);  // 수정 안 되게끔
        // textScreen 배치 
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        // 패널에 버튼 저장
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        // 그 패널을 배치 
        add(panel, BorderLayout.SOUTH);
        // 표시 
        pack();
        setVisible(true); // 화면에 보이게 됨
        // 리스너 설정 
        // 중요) functional interface : 메소드가 딱 하나만 선언되어 있는 인터페이스
        // functional interface 객체가 들어갈 자리에는 람다식을 넣을 수 있다.
        buttonUse.addActionListener(this);  // ActionListener 객체의 actionPerformed()가 호출됨 
        // buttonUse.addActionListener( (e) -> {state.doUse(this);} );    // ActionEvent 객체를 인자로 받음

        buttonAlarm.addActionListener(this);
        // buttonAlarm.addActionListener( (e) -> {state.doAlarm(this);} );

        buttonPhone.addActionListener(this);
        // buttonPhone.addActionListener( (e) -> {state.doPhone(this);});

        buttonExit.addActionListener(this);
        // buttonExit.addActionListener( (e) -> {System.exit(0)});
    }

    // 버튼이 눌리면 여기로 온다
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());   // e.getSource() : 이벤트가 어디서 발생했는지 (어떤 이벤트가 발생했는지) 얻어옴
        if (e.getSource() == buttonUse) {		// 금고 사용 버튼
            state.doUse(this);  // 매우 중요) 현재 상태 객체의 doUse()를 호출함 => 주간인지 야간인지 검사할 필요가 없음 (상태가 객체이니까)
        } else if (e.getSource() == buttonAlarm) {	// 비상벨 버튼 
            state.doAlarm(this);
        } else if (e.getSource() == buttonPhone) {	// 일반 통화 버튼  
            state.doPhone(this);
        } else if (e.getSource() == buttonExit) {	// 종료 버튼 
            System.exit(0);
        } else {
            System.out.println("?");
        }
    }

    // 시간 설정 
    @Override
    public void setClock(int hour) {
        String clockstring = String.format("현재 시간은 %02d:00", hour);
        
        System.out.println(clockstring);

        textClock.setText(clockstring);
        
        state.doClock(this, hour);
    }

    // 상태 변화 
    @Override
    public void changeState(State state) {
        System.out.println(this.state + "에서" + state + "으로 상태가 변화했습니다.");
        this.state = state; // 현재 상태를 바꿔줌
    }

    // 경비 센터 경비원 호출
    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }

    // 경비 센터 기록 
    @Override
    public void recordLog(String msg) {
        textScreen.append("record ... " + msg + "\n");
    }
}
