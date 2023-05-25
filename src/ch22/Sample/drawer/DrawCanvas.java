package ch22.Sample.drawer;

import ch22.Sample.command.MacroCommand;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

// Drawable 인터페이스의 draw 메소드를 구현한, 실제 그림 그리는 클래스
public class DrawCanvas extends Canvas implements Drawable {
    // 속성
    // 그리는 색 
    private Color color = Color.red;
    // 그리는 점의 반지름 
    private int radius = 6;
    // 이력 
    private MacroCommand history;   // 그릴 때 만들어졌던 코멘드 객체를 여기서 관리함

    // 생성자 
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    // 메소드
    // 이력 전체 다시 그리기 
    @Override
    public void paint(Graphics g) { // 그래픽스 객체를 이용하여 그림 그리므로 
        history.execute();  // draw command의 execute()가 실행됨
    }

    // 그리기 
    @Override
    public void draw(int x, int y) {    // draw()는 좌표 값만 얻어오게 되어있고 그래픽스 객체가 없으므로
        Graphics g = getGraphics();     // 그래픽스 객체를 얻어와야 함 (getGraphics() 사용)
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2); // 원이 그려질 사각형을 지정함 (x, y, 사각형 가로, 사각형 세로)
        // 마우스 이벤트 발생한 좌표(x, y)를 중심으로, 그려낼 원의 반지름만큼 각각 빼주면 됨
    }
}
