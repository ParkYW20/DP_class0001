package ch12.Sample;

public class Main {
    public static void main(String[] args) {
        // 중심을 생성
        Display b1 = new StringDisplay("Hello, world.");

        // 중심을 장식, 장식한 결과물이 내용물(장식대상)이 될 수 있다
        Display b2 = new SideBorder(b1, '#');
        Display b3 = new FullBorder(b2);
        
        b1.show();
        b2.show();
        b3.show();
        
        Display b5 = new FullBorder(b1);
        b5.show();

        Display b6 =new FullBorder(b5);
        b6.show();

        Display b4 =
                    new SideBorder(
                        new FullBorder(
                            new FullBorder(
                                new SideBorder(
                                    new FullBorder(
                                        new StringDisplay("Hello, world.")
                                    ),
                                    '*'
                                )
                            )
                        ),
                        '/'
                    );
        b4.show();
    }
}
