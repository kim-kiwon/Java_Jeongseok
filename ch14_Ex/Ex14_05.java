import java.util.*;
import java.util.stream.*;

public class Ex14_05 {
	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(
			new Student("이자바", 3, 300),
			new Student("김자바", 1, 200),
			new Student("안자바", 2, 100),
			new Student("박자바", 2, 150),
			new Student("소자바", 1, 200),
			new Student("나자바", 3, 290),
			new Student("감자바", 3, 180)
		);
		
		studentStream.sorted(Comparator.comparing(Student::getBan) //1. 반별정렬
				.thenComparing(Comparator.naturalOrder())) // 2. 기본정렬
				.forEach(System.out::println);
	}

}

//Student 클래스 작성.
//Comparable 인터페이스 구체화.
//Comparable의 제네릭스의 비교대상인 Student 넣어줌.
class Student implements Comparable<Student> {
	String name;
	int ban;
	int totalScore;
	Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}
	
	String getName() { return name;}
	int getBan() {return ban;}
	int getTotalScore() {return totalScore;}
	
	//기본정렬 -> 총점 내림차순으로 한다.
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}