import java.util.*;

public class Ex11_11 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		set.add("abc");
		set.add("abc");
		set.add(new Person("David", 10));
		set.add(new Person("David", 10));
		//hash에서 객체의 멤버변수가 모두 같은데 다른 객체로 인식해 hash set에 추가된다.
		//같은 객체 인식하게 하려면. 객체 클래스에 equals와 hashCode 메서드를 오버라이딩 해주어야한다.
		
		System.out.println(set);
	}
}

class Person {
	String name;
	int age;
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
	//hashCode 오버라이딩. Objects.hash에 멤버변수들을 넣어주면 된다.
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) return false; //비교대상인 매개변수가 Person 형으로 형변환 가능한가?
		
		Person p = (Person)obj; //매개변수를 Person 형으로 형변환해 p에 저장.
		
		return this.name.equals(p.name) && this.age == p.age; //메서드 호출 객체와 매개변수 객체간에 멤버변수 값 비교.
	}
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String toSring() {
		return name + ":" + age;
	}
}
