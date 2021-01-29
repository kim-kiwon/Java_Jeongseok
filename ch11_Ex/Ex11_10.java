import java.util.*;

public class Ex11_10 {

	public static void main(String[] args) {
		Set set = new HashSet();
		
		for(int i = 0; set.size() < 6; i++) {
			int num = (int)(Math.random()*45) + 1;
			set.add(new Integer(num));
		}
		
		List list = new LinkedList(set);
		//set은 순서 X. 따라서 sort가 불가능하다.
		//LinkedList(collection) 생성자를 이용해서 List 객체 생성.
		//list를 정렬한다.
		Collections.sort(list);
		System.out.println(list);
	}

}
