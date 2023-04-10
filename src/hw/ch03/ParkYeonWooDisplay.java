// 20200207 박연우
package hw.ch03;

public class ParkYeonWooDisplay extends AbstractDisplay {

    // 속성
    private String name;
    private String studentId;
    private int grade;

    // 생성자
    public ParkYeonWooDisplay(String name, String studentId, int grade) {
        this.name = name;
        this.studentId = studentId;
        this.grade = grade;        
    } 

    // 메소드 구현
    @Override
    public void open() {
        System.out.println("====================\n" + "덕성여대 국어국문학전공");
    }

    @Override
    public void print() {
        System.out.println("이름: "+ name + "/ 학번: " + studentId + "/ 학년: " + grade);
    }

    @Override
    public void close() {
        System.out.println("템플릿 메소드 패턴 숙제입니다.\n" + "====================");
    }


}
