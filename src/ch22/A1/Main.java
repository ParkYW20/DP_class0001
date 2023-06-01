package ch22.A1;

import ch22.A1.command.*;
import ch22.A1.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Client(의뢰자) 역할 & Invoker(기동자) 역할
public class Main extends JFrame implements MouseMotionListener, WindowListener {
    // 그리기 이력 
    private MacroCommand history = new MacroCommand();
    // 그리는 영역 
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 삭제 버튼 
    private JButton clearButton  = new JButton("clear");
    // 빨간 버튼 
    private JButton redButton  = new JButton("red");
    // 초록 버튼
    private JButton greenButton  = new JButton("green");
    // 파란 버튼
    private JButton blueButton  = new JButton("blue");

    // 생성자 
    public Main(String title) {
        super(title);

        // button click, mouse click 등을 받아들이는 listener를 설정함
        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);

        // !) ActionPerformed() 대신 lambda식으로 간략하게 만들었구나!
        clearButton.addActionListener(e -> {    // 람다식
            history.clear();
            canvas.init();
            canvas.repaint();
        });
        redButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.red);  // 컬러커맨드, 두 번째 인자로 색깔을 넣어줌
            history.append(cmd);
            cmd.execute();
        });
        greenButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.green);
            history.append(cmd);
            cmd.execute();
        });
        blueButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.blue);
            history.append(cmd);
            cmd.execute();
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS); // Layout manager
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS); // y축을 기준으로 배치하라고 명령하였으므로
        mainBox.add(buttonBox); // 입력 순으로 세로 방향 배치
        mainBox.add(canvas);

        getContentPane().add(mainBox);  // 이 코드가 없으면 윈도우 창만 뜨고, 내용물이 담기지 않음 (버튼, 캔버스 등)

        pack(); // 무슨 역할?
        setVisible(true);
    }

    // MouseMotionListener용
    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    // WindowListener용
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0); // 프레임이 몇 개가 떠 있든지, 지금까지 하던 일을 모두 그만 두고 프로그램을 종료 시킴
                // ** dispose(); 현재의 프레임 윈도우만 사라짐, 프레임 위의 모든 컴포넌트를 os에게 반납 및 처분함, 프로그램 종료 X
    }

    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
