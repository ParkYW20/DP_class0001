package ch22.Sample.drawer;

import ch22.Sample.command.Command;
import java.awt.Point;

// 드래그 할 시, draw 객체를 만들어서 관리하겠다
public class DrawCommand implements Command {   // 무언가를 하는 클래스이므로 대상이 필요
    // 그리는 대상 
    protected Drawable drawable;    // receiver

    // 그리는 위치 
    private Point position;

    // 생성자 
    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    // 실행
    @Override
    public void execute() {
        drawable.draw(position.x, position.y);  // 실제 그리는 일을 함
                    // 그림 그릴 때 필요한 좌표를 줌: Point.x, Point.y 포인트 클래스
    }
}
