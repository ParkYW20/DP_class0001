package ch22.A1.command;

import java.util.ArrayDeque;
import java.util.Deque;

// ConcreteCommand(구체적인 명령) 역할
// 여러 개의 명령을 한 데 모은 것(container)이면서 동시에 그 자체로 하나의 명령 (content)
public class MacroCommand implements Command {
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>();

    // 실행 
    @Override
    public void execute() {
        for (Command cmd: commands) {   // 자신이 가지고 있는 모든 명령의 excute()를 호출하는 메소드
            cmd.execute();  // MacroCommand 인스턴스(명령)가 있으면 그 인스턴스가 가진 명령들의 excute() 실행시킴
        }
    }

    // 추가 
    public void append(Command cmd) {   // 이 클래스에 new Command 인스턴스를 추가하는 메소드
        if (cmd == this) {  // 실수로 자기 자신을 추가하지 않도록 체크함
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // 마지막 명령을 삭제
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear();   // Deque<Command> 객체의 모든 명령(원소)을 삭제
    }

    public void redo() {
    }
}
