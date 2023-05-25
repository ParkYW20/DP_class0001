package ch22.Sample;

import ch22.Sample.command.*;
import ch22.Sample.drawer.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

// MouseMotionListener : 마우스 이벤트 발생하면 얘가 일함
// WindowListener : 윈도우를 하나 띄우면 여러 액션을 할 수 있는데, 그 때마다 윈도우 이벤트가 발생하면 윈도우 리스너가 일함
public class Main extends JFrame implements MouseMotionListener, WindowListener {
// public class Main extends JFrame, WindowAdapter implements MouseMotionListener { // 이미 다른 것을 상속 받았기 때문에 윈도우 어댑터 상속이 불가능

    // 속성 (instance field)
    // 그리기 이력 
    private MacroCommand history = new MacroCommand();
    // 그리는 영역 
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 삭제 버튼
    private JButton clearButton  = new JButton("clear");

    // 생성자 
    public Main(String title) {
        super(title);

        // 리스너 등록
        this.addWindowListener(this);

        // canvas.addMouseMotionListener(this);

        // 익명의 내부 클래스를 이용해서 리스너 등록해보기
        canvas.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
            }
            public void mouseDragged(MouseEvent e) {
                Command cmd = new DrawCommand(canvas, e.getPoint());
                history.append(cmd);
                cmd.execute();
            }
        } );

        // 익명의 내부 클래스와 어댑터를 이용해서 리스너 등록해보기


        


        // ActionListener는 functional interface(actionPerformed 하나만 선언되어 있기 때문)
        // Functional Interface가 들어갈 자리에는 람다식을 넣을 수 있음
        clearButton.addActionListener(e -> {
            history.clear();  // history의 draw command 내용이 지워짐
            canvas.repaint(); // (1) 내용이 지워짐 (2) paint() 자동으로 호출됨
        });

        // GUI 컴포넌트 추가
        Box buttonBox = new Box(BoxLayout.X_AXIS);  // 가로로 배치하겠다는 뜻
        buttonBox.add(clearButton);

        Box mainBox = new Box(BoxLayout.Y_AXIS);    // 세로로 배치하겠다는 뜻
        mainBox.add(buttonBox);
        mainBox.add(canvas);

        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    // MouseMotionListener용
    // 마우스로 할 수 있는 동작: (1)안 누르고 움직임 (2)누르고(드래그 한 상태에서) 움직임
    @Override
    public void mouseMoved(MouseEvent e) {   // (1) 마우스 움직이기만 하면 아무 일도 일어나지 않음
    }

    @Override
    public void mouseDragged(MouseEvent e) { // (2) 마우스를 드래그 한 상태에서 움직이면,
        Command cmd = new DrawCommand(canvas, e.getPoint());  // event.getPoint(): 이벤트가 발생한 곳의 좌표를 줌
        // System.out.println("드래그 이벤트 발생: x좌표: " + e.getPoint().getX());
        // System.out.println("드래그 이벤트 발생: y좌표: " + e.getPoint().getY());

        history.append(cmd);
        cmd.execute();
    }

    // WindowListener용 
    // ** 창에서 이벤트가 발생했을 때, 상황마다 다른 무언가를 동작시키고 싶으면, 윈도우 Listener를 구현해주면 됨
    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("윈도우가 닫힙니다.");
        System.exit(0);
    }

    @Override public void windowActivated(WindowEvent e) {} // 언제 호출되는지 다 정해져 있음
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {
        System.out.println("윈도우가 미니마이즈됩니다.");
    }
    @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
