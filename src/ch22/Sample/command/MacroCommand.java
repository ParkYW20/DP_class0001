package ch22.Sample.command;

import java.util.ArrayDeque;
import java.util.Deque;

// 만들어진 draw command 객체를 관리하는 클래스
public class MacroCommand implements Command {
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>(); // 컬렉션 
                                                          // (원래는 stack 이라는 클래스를 이용. Deque은 stack과 que 둘 다 이용 가능함)

    // 실행 
    @Override
    public void execute() {
        for (Command cmd: commands) {   // 내부적으로 iterator() 메소드를 호출해서 작동함
            cmd.execute();  // 자기가 포함하고 있는 command의 excute()을 실행 시킴
        }
    }

    // 추가 
    public void append(Command cmd) {
        if (cmd == this) {  // 매크로 코멘드 안에 넣을 객체가 같은지 다른지 비교함
            throw new IllegalArgumentException("infinite loop caused by append");  // 예외 발생 시킴
        }
        commands.push(cmd);
    }

    // 마지막 명령을 삭제
    public void undo() {    // 이 예제에서는 아직 필요하지 않음
        if (!commands.isEmpty()) {  // undo()는 제일 최근 것을 뺄 수 있다
            commands.pop();
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear();   // 스택 안에 있던 모든 원소를 지워버림
    }
}
