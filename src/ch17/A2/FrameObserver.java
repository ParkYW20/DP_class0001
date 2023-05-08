package ch17.A2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameObserver extends Frame implements Observer, ActionListener {
    // 내부 클래스 : 아래 두 클래스는 이 클래스 내부에서만 사용되는 클래스들임

    // GraphText는 통지된 수를 텍스트 필드로 표시하는 static 클래스 
    static class GraphText extends TextField implements Observer {  // TextField는 입력할 때 사용하는 입력 칸 (그래프텍스트는 특수한 형태의 텍스트 필드)
        public GraphText(int columns) {
            super(columns);
        }

        @Override
        public void update(NumberGenerator generator) {
            int number = generator.getNumber();
            String text = number + ":";
            for (int i = 0; i < number; i++) {
                text += '*';
            }
            setText(text);
        }
    }

    // GraphCanvas는 통지된 수를 원그래프로 표시하는 static 클래스 
    static class GraphCanvas extends Canvas implements Observer {   // 그래프캔버스는 특수한 형태의 도화지구나!
        private int number;

        @Override
        public void update(NumberGenerator generator) {
            number = generator.getNumber();
            repaint();
        }

        public void paint(Graphics g) {
            int width = getWidth();
            int height = getHeight();
            g.setColor(Color.white);
            g.fillArc(0, 0, width, height, 0, 360);
            g.setColor(Color.red);
            g.fillArc(0, 0, width, height, 90, - number * 360 / 50);
        }
    }

    private GraphText textGraph = new GraphText(60);
    private GraphCanvas canvasGraph = new GraphCanvas();
    private Button buttonClose = new Button("Close");   

    public FrameObserver() {
        super("FrameObserver");

        setLayout(new BorderLayout());
        
        setBackground(Color.lightGray);
        
        textGraph.setEditable(false);   // 뭘 입력하려 할 때 입력 안 되게끔
        
        canvasGraph.setSize(500, 500);  // 도화지 크기를 지정
        
        add(textGraph, BorderLayout.NORTH); // 상수들(NORTH 등)은 BorderLayout 클래스 안에 지정되어 있음
        add(canvasGraph, BorderLayout.CENTER);
        add(buttonClose, BorderLayout.SOUTH);
        buttonClose.addActionListener(this);    // actionPerformed() 호출 (?)
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }

    @Override
    public void update(NumberGenerator generator) {
        textGraph.update(generator);
        canvasGraph.update(generator);
    }
}

