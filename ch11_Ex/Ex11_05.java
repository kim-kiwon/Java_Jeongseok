import java.util.*;

public class Ex11_05 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		// Collecton list = new ArrayList();
		// 다형성. Collection의 메서드만 사용시 Collection을 참조변수로 쓰자.
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator it = list.iterator();
		//list에서 iterator 메서드 호출. Iterator 객체 반환.
		//list의 처음부터 시작.
		
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		//while문 끝나면 끝까지 다읽음. 다시 읽으려면 새로 Iterator 객체 얻어와야함.
		
		for(int i = 0; i<list.size(); i++) {
			Object obj = list.get(i);
			System.out.println(obj);
		}
		//for문으로 구현한것.
		//iterator쓰는 이유. list변수를 다른 Collections의 자손인 set으로 바꾸면
		//set에는 get 메서드가 없기에 동작 안한다.
		//Iterator는 Collections 클래스의 자손에 다음거 읽어오도록 정규화됨.
		
		
		//map은 Collection이 자손이 아님.
		//map의 set함수로 뽑아낸 뒤 iterator 적용해야함.
	}

}
