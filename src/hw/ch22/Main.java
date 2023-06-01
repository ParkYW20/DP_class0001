package hw.ch22;

import ch22.A1.command.*;
import ch22.A1.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
    // (from 'a2') 실행 취소 버튼 (undo)
    private JButton undoButton = new JButton("undo");
    // (new) redo 버튼 
    private JButton redoButton = new JButton("redo");

    // 생성자 
    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);

        // ** ActionPerformed() 역할을 lambda expression이 대신함
        clearButton.addActionListener(e -> {
            history.clear();
            canvas.init();  // ** 색깔 초기화
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
        // (from 'a2') undo 버튼의 리스너 추가
        undoButton.addActionListener(e -> {
            history.undo();
            canvas.repaint();   // 해당 인스턴스의 paint()를 호출
        });
        // (new) redo 버튼의 리스너 추가
        redoButton.addActionListener(e -> {
            history.redo();
            canvas.repaint();
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        buttonBox.add(undoButton);  // (from 'a2') undoButton을 추가
        buttonBox.add(redoButton);  // (new) redoButton을 추가
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox); 
        mainBox.add(canvas);

        getContentPane().add(mainBox);

        pack();
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
        System.exit(0); // 프레임이 몇 개가 떠 있든지, 지금까지 하던 일을 모두 그만 두고 프로그램을 종료 시킴 (vs. dispose();)
    }

    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern homework [20200207 박연우]");
    }
}
