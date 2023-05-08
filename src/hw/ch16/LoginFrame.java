package hw.ch16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueCheckbox checkMember;  // 추가: "member" 라디오 버튼

    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueTextField textSSN;     // 추가: "주민등록번호" textField
    
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // Colleague를 생성하고 배치한 후에 표시한다
    public LoginFrame(String title) {
        super(title);   

        // 배경색을 설정한다
        setBackground(Color.lightGray);

        // 레이아웃 매니저를 사용해 5×3 그리드를 만든다
        setLayout(new GridLayout(5, 3));    // 수정

        // Colleague를 생성한다 
        createColleagues();

        // 배치한다 
        add(checkGuest);
        add(checkLogin);
        add(checkMember);   // 추가: member 라디오 버튼
        add(new Label("Username:"));
        add(textUser);
        add(new Label(" "));    // 빈 문자열을 추가하여 빈 칸을 만듦
        add(new Label("Password:"));
        add(textPass);
        add(new Label(" "));
        add(new Label("주민등록번호:"));    // 추가: 주민등록번호 라벨
        add(textSSN);   // 추가: 주민등록번호 텍스트 필드
        add(new Label(" "));
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
        checkMember = new ColleagueCheckbox("Member", g, false);  // 추가: member 라디오 버튼 (Colleague) 생성

        // TextField
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textSSN = new ColleagueTextField("", 20);   // 추가: 주민등록번호 textField (Colleague) 생성
        textPass.setEchoChar('*');

        // Button
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator를 설정한다 
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        checkMember.setMediator(this);  // 추가: 'member 라디오 버튼'의 중재자를 설정
        textUser.setMediator(this);
        textPass.setMediator(this);
        textSSN.setMediator(this);  // 추가: '주민등록번호 입력란'의 중재자를 설정
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener 설정
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        checkMember.addItemListener(checkMember);   // 추가: member 라디오 버튼의 리스너 연결 
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        textSSN.addTextListener(textSSN);      // 추가: 주민등록번호 텍스트 필드의 리스너 연결
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleage의 상태가 바뀌면 호출된다
    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {    // Guest 라디오 버튼이 선택된 상태 (기본 상태)
            // 게스트 로그인
            // => username/password/주민등록번호 입력란과 OK 버튼을 비활성화 상태가 되도록 로직을 추가/수정 하였음
            textUser.setColleagueEnabled(false);   
            textPass.setColleagueEnabled(false); 
            textSSN.setColleagueEnabled(false);   // 추가: 주민등록번호 입력란
            buttonOk.setColleagueEnabled(false);  // 수정: OK 버튼. 활성화 -> 비활성화 상태로 수정함
        } else if (checkMember.getState()) {              // 사용자가 Member 라디오 버튼을 선택하면,
            // member 로그인 
            textUser.setColleagueEnabled(true);   // username 입력란이 활성화된다
            userpassChanged();
        } else {
            buttonOk.setColleagueEnabled(false);  // Login 버튼이 선택된 상태에서는 OK 버튼이 비활성화 된다
        }
    }

    // 각 Colleage의 활성/비활성을 판정한다
    private void userpassChanged() {
        if (textUser.getText().length() > 0) {              // username 입력을 시작하면,
            textPass.setColleagueEnabled(true);     // Password 입력란이 활성화된다
            if (textPass.getText().length() > 0) {          // password 입력을 시작하면, 
                textSSN.setColleagueEnabled(true);  // 주민등록번호 입력란이 활성화된다
                
                // 사용자가 주민등록번호 13자리를 조건에 맞게 정확히 입력하면 OK 버튼이 활성화된다
                if (textSSN.getText().length() > 0) {       // 주민등록번호 입력을 시작하면,
                    char i = textSSN.getText().charAt(textSSN.getText().length() - 1); // 문자열의 길이를 구하고, charAt()을 사용하여 문자로 반환시킨다
                    if (Character.isDigit(i) == true) {                  // 가장 최근에 입력한 (index == i인) 문자의 숫자 여부를 확인한다 (숫자이면 true)
                        if (textSSN.getText().length() == 13) {          // 입력한 숫자가 13자리이면, 
                            System.out.println("13자리입니다.");        // (터미널에 메시지가 뜬다)
                            buttonOk.setColleagueEnabled(true);  // OK 버튼이 활성화된다
                        } else if (textSSN.getText().length() < 13) {    // 입력한 숫자가 13자리 미만이면, 
                            buttonOk.setColleagueEnabled(false); // OK 버튼을 비활성화 상태로 둔다
                        } else {    
                            // 주민등록번호는 13자리이므로 사용자가 13자리를 초과하여 입력하면 알림 창을 띄운다
                            JOptionPane.showMessageDialog(null, "13자리를 초과하였습니다. 다시 입력해주십시오.", 
                            "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                            buttonOk.setColleagueEnabled(false);    // OK 버튼이 비활성화 된다
                        }
                    } else {    
                        // 가장 최근에 입력한 문자가 숫자 이외의 문자이면, 문자를 입력하는 순간 문자를 입력하지 말라는 경고 창을 띄운다
                        buttonOk.setColleagueEnabled(false);
                        JOptionPane.showMessageDialog(null, "문자를 입력하지 마십시오.",
                        "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);

                        // 경고 창에서 확인 버튼을 누르면 입력했던 한 문자는 사라진다
                        String result = textSSN.getText().substring(0, textSSN.getText().length() - 1);
                        textSSN.setText(result);    // '마지막 문자 (숫자가 아닌 문자)'를 자르고, 그 전까지의 문자열을 다시 대입한다

                        // 다시 그 위치부터 주민번호 입력이 가능하도록 한다
                        textSSN.setCaretPosition(textSSN.getText().length());
                    }
                } else {
                    buttonOk.setColleagueEnabled(false);
                }
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
