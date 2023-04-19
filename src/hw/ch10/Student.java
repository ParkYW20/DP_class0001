// 20200207 박연우

package hw.ch10;

public class Student implements Comparable<Student> {

	// 속성
	String name = "";
	String id = "";
	int height = 0;
	
	// 생성자
	public Student(String name, String id, int height) {	 
		this.name = name;
		this.id = id;
		this.height = height;
	}

	// 메소드
	// 현재 Student 객체와 인자로 들어온 Student 객체의 height 크기를 비교함
	@Override
	public int compareTo(Student s) {
		return this.height - s.height;
		// 문자열을 비교할 시 유니코드의 차를 반환 => 정수형을 비교하므로 숫자의 차를 반환하도록 수정함
		// 현재 객체의 height이 더 작으면 음수를 반환
	}
	
	// 학생들의 이름과 키를 읽기 좋게끔 출력함
	public String toString() {
		return "(이름: " + this.name + ", 학번: " + this.id + ", 키:" + this.height + ")\n";
	}

	/*
	 * 연습 문제와 달리, 새로운 클래스를 추가로 생성하여 (과제의 Student 클래스) 객체(Student 인스턴스)를 정렬할 경우
	 * 그리고 정렬할 인스턴스의 클래스가 'Comparable'을 구현할 경우
	 	
	 	Q. 왜 Student 클래스와 Comparator 클래스에서 중복하여
		 compare(){return o1.compareTo(o2);}와 compareTo() 메소드를 구현해야 하는가?	(compareTo()가 중복됨)

	 	=> 2개의 Comparator 클래스가 모두 Comparator<Student>, 즉 정렬 대상인 원소가 특정 객체(Student)임을 가정하고 구현하므로 
	 		객체의 어떤 속성을 기준으로 비교할지를 Student 클래스를 통해 우선하여 정해주어야 함
	 	=> 또한 Student 클래스에서 compareTo() 메소드를 오버라이딩했고, 그 클래스를 Comparator 클래스가 implements 하여
	 		compareTo()를 호출하기 때문에 Student 클래스에서 compareTo() 메소드를 반드시 구현해야 함 (+ 인터페이스는 메소드 구현을 '강제'함)
	 
	 	Q. return s.height - this.height; 으로 바꿀 경우, Main에서 정렬 시 오름차순과 내림차순 Comparator 결과가 각각 반대로 바뀜. 왜?
		=> 반환하는 값의 부호가 반대로 바뀜. Student 클래스의 compareTo() 실행 결과가 Main에서 어떻게 적용이 되는가?
	 */
}
