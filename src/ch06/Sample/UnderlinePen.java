package ch06.Sample;

import ch06.Sample.framework.Product;

public class UnderlinePen implements Product {
    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;   // 밑줄 그을 캐릭터
    }

    @Override
    public void use(String s) {
        int ulen = s.length();

        System.out.println(s);
        for (int i = 0; i < ulen; i++) {
            System.out.print(ulchar);   // 길이만큼 출력
        }

        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {    // 예외처리
            e.printStackTrace();
        }
        return p;
    }
}
