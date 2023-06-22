package ch16.Sample;

public class Main {
    static public void main(String[] args) {
        new LoginFrame("Mediator Sample");
    }

    /*
    1) LoginFrame <-> ColleagueCheckBox
     * LoginFrame 생성 => GUI 윈도우 생성 (콜리그 생성 및 GUI 컴포넌트 배치, mediator 설정, 리스너 설정 및 연결)
     * 사용자가 (로그인) 체크박스 클릭 (상태변화) => ColleagueCheckBox 인스턴스에서 이벤트리스너의 메소드가 실행
     * => 체크박스 인스턴스가 속성으로 가지고 있던 mediator의 colleagueChanged() 호출 (상태변화 알리는 통지가 감)
    
    2) LoginFrame <-> ColleagueTextField
     * => 메시지 받은 LoginFrame 중재자 객체는 ColleagueTextField 인스턴스의 setColleagueEnabled() 호출
     * => 즉 mediator가 textfield 인스턴스에 활성/비활성 명령 내린 것임, textfield 인스턴스는 true를 인자로 받아 (awt.Component.)setEnabled(true) 실행
     * => textfield가 사용자의 이벤트를 허용하는 상태가 됨
     * => 사용자가 텍스트 필드 안에 문자 입력하면 (상태 변화) -> textListener의 textValueChanged(TextEvent e) 실행됨
     * => 중재자(loginFrame)에 colleagueChanged() 호출하여 통지 보냄
    
    3) LoginFrame <-> ColleagueButton
     * => textfield 인스턴스('textUser')의 setColleagueEnabled(true) 호출, userpassChanged() 실행
     * => true를 인자로 받아 textfield는 클릭이 가능한(이벤트 발생 가능한) 상태가 됨
     * => userpassChanged() : textUser에 1글자 이상 입력되면 textPass의 setColleagueEnabled(true),
     * =>   textPass에 1글자 이상 입력되면 ColleagueButton 인스턴스인 buttonOK에 setColleagueEnabled(true) 호출 (지시를 내림)
     * =>   OK 버튼이 활성화 되고, 만약 사용자가 버튼을 클릭하면 (이벤트가 발생하여) 자기 mediator 속성의 colleagueChanged() 를 호출한다 (=loginframe에 상태변화 통지)
    
    4) 사용자가 다시 체크박스 클릭할 수 있는 상태
     * => textUser에 활성화 명령 유지, userpassChanged() 
     * => ColleagueCheckBox 인스턴스에 명령
     */
}
