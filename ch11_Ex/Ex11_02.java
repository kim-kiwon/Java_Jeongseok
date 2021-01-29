
import java.util.*;

public class Ex11_02 {
	public static void main(String[] args) {
		Stack st = new Stack(); //Stack 클래스 객체 생성.
		Queue q = new LinkedList(); 
		//Queue는 인터페이스라 객체 생성 불가능. Queue 를 직접 구현하던가. 구현체 자손인 LinkedList 사용.
		
		st.push("0"); 
		st.push("1");
		st.push("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("= Stack =");
		while(!st.empty()) {
			System.out.println(st.pop()); //stack이 빌때까지 pop. LIFO이므로 2부터 나온다.
		}
		
		System.out.println("= Queue =");
		while(!q.isEmpty()) {
			System.out.println(q.poll()); //queue가 빌때까지 poll. FIFO이므로 0부터 나온다.
		}
	}

}
