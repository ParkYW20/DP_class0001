package hw.ch05.idcard;

import hw.ch05.framework.Product;

public class IDCard extends Product {
    private String owner;
    private int serial;

    // 패키지 visibility
    IDCard(String owner, int serial) {  
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");    // + : 문자열 연결, this 는 문자열이 아님 -> 객체의 this.toString()을 호출함
            // this는 idcard 타입
    }

    @Override
    public String toString() {  // Object 클래스로부터 상속
        return "[IDCard:" + owner + "]";
    }

    public String getOwner() {
        return owner;
    }
}
