package ch22.A1.drawer;

import java.awt.Color;

public interface Drawable {
    public abstract void init();
    public abstract void draw(int x, int y);    // 점 그리는 메소드
    public abstract void setColor(Color color);
}
