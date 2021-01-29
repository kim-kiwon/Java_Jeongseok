import java.util.*;

public class Ex12_02 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>(); //생성자 타입지정 생략가능. <>만.
		list.add(new Student("자바왕", 1, 1));
		list.add(new Student("자바짱", 1, 2));
		list.add(new Student("홍길동", 2, 1));
		
		Iterator<Student> it = list.iterator(); //Iterator의 메서드 반환형 Object. but Student를 지네릭스로 지정.
												//메서드 반환형들 Student 가 된다.
		while (it.hasNext()) {
			//Student s = it.next(); //Student s = (Student)it.next();     원래 Object라 형변환 필요. 지네릭스 덕 생략.
			//System.out.println(s.name);
			System.out.println(it.next().name);
		}
	}
}

class Student {
	String name = "";
	int ban;
	int no;
	
	Student(String name, int ban, int no) {
		this.name = name;
		this.ban = ban;
		this.no = no;
	}
}