package hw.ch22.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class MacroCommand implements Command {
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>();
    private Deque<Command> commandsForRedo = new ArrayDeque<>(); // (new) undo 시 삭제되었던 명령어들을 보관하는 변수

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
        commandsForRedo.clear(); // 추가
        commands.push(cmd);
    }

    // 마지막 명령을 삭제
    public void undo() {
        if (!commands.isEmpty()) {  // 원소가 있으면
            Command undoCommand = commands.pop();  // 마지막 원소를 꺼내와 commandsForRedo 속성에 추가
            // undoCommand.undo();
            commandsForRedo.push(undoCommand);
            /* 
            add()와 Push()는 차이가 있음 (oracle 기술 문서 Deque.class 참고)
            - push()는 Deque의 head(front)에서부터 원소를 넣지만, (= addFirst)
            - add()는 tail(end)에서부터 원소를 넣음 (= addLast)
            */
        }
    }

    // 삭제된 마지막 명령을 다시 그림
    public void redo() {
        if (!commandsForRedo.isEmpty()) { // commandsForRedo에 원소가 있으면
            Command redoCommand = commandsForRedo.pop();  // 마지막 원소를 꺼내와 commands 속성에 되돌려줌
            // redoCommand.append();
            commands.push(redoCommand);
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear();   // Deque<Command> 객체의 모든 명령(원소)을 삭제
    }
}
