package hw.ch22.drawer;

import java.awt.Color;

// 그림 그리기 대상을 표현하는 인터페이스
public interface Drawable {
    public abstract void init();
    public abstract void draw(int x, int y);    // 점 그리는 메소드
    public abstract void setColor(Color color);
}
