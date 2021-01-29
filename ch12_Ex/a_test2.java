import java.util.*;

class Book {}
class Note extends Book {}

public class a_test2 {
	public static void main(String[] args) {
		ArrayList<Book> list = new ArrayList<Book>();
		//참조변수 타입과. 생성자 타입은 기본적으로 같다. 다형성도 안됨. 일치해야함.
		//지네릭 클래스간 다형성은 성립
		//List<Book> list = new ArrayList<Book>();
		
		list.add(new Note());
		//list.add(new Audio());
		//매개변수의 다형성은 성립.
		//지네릭스가 Book인 ArrayList list에. 그 자손인 Note 객체 add 가능.
		
		//즉 클래스와 매개변수 다형성은 지네릭스 써도 성립
		//타입 변수를 Object를 하면 모든 객체를 담을 수 있는 이유
		Book t = list.get(0); //원래 반환형 Object.
							//지네릭스 덕에 반환형이 타입변수에 넣어준 Book이됨.
							//형변환 필요없다.
	}

}
