package ch07.practice;

public class Director {
    private Builder builder;    // 부모 타입

    // 생성자 
    public Director(Builder builder) {
        this.builder = builder;  
    }

    // 문서를 만드는 메소드
    public void construct() {   // 빌더에게 일을 시킴
        // builder.makeTitle("Greeting");
        builder.makeTitle("박연우");
        builder.makeString("일반적인 인사");
        builder.makeItems(new String[]{
            "How are you?",
            "Hello.",
            "Hi.",
        });
        builder.makeString("시간대별 인사");
        builder.makeItems(new String[]{
            "Good morning.",
            "Good afternoon.",
            "Good evening.",
        });
        builder.close();
    }
}
