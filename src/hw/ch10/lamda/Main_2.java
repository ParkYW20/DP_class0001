package hw.ch10.lamda;

import java.util.*;
import hw.ch10.Student;

public class Main_2 {
    public static void main(String[] args) {
        // 속성
		
		// 생성자
		Student a = new Student("최승훈", "2000****", 190);	// Student 객체 생성
		Student b = new Student("박연우", "20200207", 161);
		Student c = new Student("이 정", "20191234", 158);
		Student d = new Student("김예원", "20191234", 156);
		Student e = new Student("양민경", "20121234", 159);
		
		List<Student> list = Arrays.asList( a, b, c, d, e);	// list 객체 생성
		
		// 메소드
		System.out.println(" 학번: 20200207, 이름: 박연우 \n");
		
		// 이하 람다식: Student 클래스의 compareTo()를 호출 (list 객체에서 정렬하려는 원소들이 Student 인스턴스이므로 가능함)
        list.sort((S1, S2) -> S1.compareTo(S2)); 
		System.out.println("** (1) 정렬 결과 (오름차순)\n" + list + "\n");

		list.sort((S1, S2) -> S2.compareTo(S1));
		System.out.println("** (2) 정렬 결과 (내림차순)\n" + list);
	}

}