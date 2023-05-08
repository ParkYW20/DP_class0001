package ch16.Sample;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;

    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // Colleague를 생성하고 배치한 후에 표시한다
    public LoginFrame(String title) {   // !) 생성자 메소드구나!
        super(title);   // 이게 없으면 부모의 인자 없는 생성자를 호출하게 됨
                        // 이 문장은 반드시 처음에 와야 함. 항상 부모 생성자는 맨 첫 줄에만 와야 함

        // 배경색을 설정한다
        setBackground(Color.lightGray);

        // 레이아웃 매니저를 사용해 4×2 그리드를 만든다
        setLayout(new GridLayout(4, 2));

        // Colleague를 생성한다 
        createColleagues();

        // 배치한다 
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        // 활성/비활성 초기 설정을 한다
        colleagueChanged();

        // 표시한다 
        pack();
        setVisible(true);
    }

    // Colleague를 생성한다
    @Override
    public void createColleagues() {
        // CheckBox
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);

        // TextField
        textUser = new ColleagueTextField("", 10);  // 초기 문자열 null로 만듦
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');  // 입력했을 때 화면에 이렇게 보임

        // Button
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator를 설정한다 
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener 설정
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleage의 상태가 바뀌면 호출된다
    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {    // Guest 체크박스가 눌러졌으면...
            // 게스트 로그인 
            textUser.setColleagueEnabled(false);    // 텍스트 유저에게 지시 내림 (비활성화 해라)
            textPass.setColleagueEnabled(false);    // 비활성화 해라
            buttonOk.setColleagueEnabled(true);     // 활성화 해라
        } else {    // Login 체크박스가 눌러졌으면...
            // 사용자 로그인 
            textUser.setColleagueEnabled(true);
            userpassChanged();  // TextField 상태 변화에 따라 활성화/비활성화
        }
    }

    // textUser 또는 textPass의 변경이 있다 
    // 각 Colleage의 활성/비활성을 판정한다
    private void userpassChanged() {
        if (textUser.getText().length() > 0) {  // username 칸에 문자열이 입력되어 있으면...
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {  // password 칸에 문자열이 입력되어 있으면...
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
