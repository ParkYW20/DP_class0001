package hw.ch22.drawer;

import ch22.A1.command.MacroCommand;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

// Receiver(수신자) 역할: Command 명령을 실행할 대상 & Invoker(기동자) 역할
public class DrawCanvas extends Canvas implements Drawable {
    // 그리기 색 
    private Color color;
    // 그리기 점의 반경
    private int radius;
    // 이력 (지금까지 실행한 명령어들의 집합)
    private MacroCommand history;

    // 생성자 
    public DrawCanvas(int width, int height, MacroCommand history) {
        // DrawCanvas 인스턴스를 초기화함
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
        init();
    }

    // 이력 전체 다시 그리기
    @Override
    public void paint(Graphics g) {
        history.execute();  // 보관되어 있는 모든 그리기 이력들을 실행함
    }

    // 초기화 : 프로그램을 처음 실행시켰을 때나 clear 버튼을 눌렀을 때 색깔이 초기화 됨
    @Override
    public void init() {
        color = Color.red;  // 시작 색깔 설정 (초기화)
        radius = 6;
        history.append(new ColorCommand(this, color));
    }

    // 그리기 
    @Override
    public void draw(int x, int y) {    // 마우스 이벤트가 발생한 곳의 좌표값
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
