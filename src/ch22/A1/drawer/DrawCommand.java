package ch22.A1.drawer;

import ch22.A1.command.Command;
import java.awt.Point;

// ConcreteCommand(구체적인 명령) 역할
// '그림 그리기 명령'을 표현하는 클래스
public class DrawCommand implements Command {
    // field (속성)
    // 그리는 대상 
    protected Drawable drawable; // 그림 그리기를 실행할 객체를 저장함
    // 그리는 위치 
    private Point position;      

    // 생성자 
    // "이 위치에 점을 그려라"라는 명령을 생성하는 생성자
    public DrawCommand(Drawable drawable, Point position) { // 도화지, 좌표
        this.drawable = drawable;
        this.position = position;
    }

    // 실행
    @Override
    public void execute() { // 실제 그리기를 실행하는 메소드
        drawable.draw(position.x, position.y);
    }
}
