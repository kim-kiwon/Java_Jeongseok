
import java.util.*; //Collections 클래스가 java.util 패키지에 존재.

public class Ex11_01 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10); //생성자. 크기가 10인 ArrayList 생성.
		list1.add(new Integer(5)); //ArrayList의 add메서드는 객체를 매개변수로 받는다.
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(3); //오토박싱을 통해 int형을 입력하면 Integer형으로 변환하여 add해준다.
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4)); // 생성자. 매개변수로 collections. 1~3까지의 subList를 생성
		print(list1, list2);
		
		// Collection은 인터페이스. Collections는 유틸의 클래스.
		Collections.sort(list1); //sort는 Collections 클래스의 static 함수.
		Collections.sort(list2);
		print(list1, list2);
		
		System.out.println("list1.containsAll(list2):"
											+ list1.containsAll(list2)); 
		//containsAll : 리스트의 메서드. 매개변수 객체가 해당 리스트에 포함 되는지 반환
		
		list2.add("B"); //오토박싱
		list2.add(new Character('C')); //원래 이렇게 해야됨.
		list2.add(3, 'A'); // add할 위치 매개변수로 입력. 3번째 위치에 A 넣어라. 기존의 것 뒤로 밀어준다. O(N)
		print(list1, list2);
		
		list2.set(3,  "AA"); // set: 변경. 3번째 원소를 AA로 바꿔라.
		print(list1, list2);
		
		list1.add(0, "1"); // 첫번째에 1을 넣으면 다 뒤로 한칸씩 민다.
		System.out.println("index=" + list1.indexOf("1"));
		//indexOf() 객체의 위치(인덱스)를 알려준다. 단 객체의 자료형도 영향을 줌.
		
		list1.remove(0); //숫자를 넣으면 n번째 원소 삭제.
		list1.remove(new Integer(1)); //객체를 넣으면 Integer형 1을 찾아 삭제
		//삭제시 빈자리 채우려고 앞으로 땡긴다.
		
		System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));
		//retainAll. 매개변수와 겹치는 부분을 제외하고 나머지 삭제.
		print(list1, list2);
		
		for(int i = list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		//get(i)로 list2에서 원소를 하나씩 꺼낸다.
		//contains()로 꺼낸 객체가 list1에 존재하는지 확인.
		//remove(i)로 해당 객체를 list2에서 삭제.
		//remove(i)는 i번째 원소 삭제. remove(객체)는 객체를 찾아 삭제.
		print(list1, list2);
	}
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1: "+list1);
		System.out.println("list2: "+list2);
		System.out.println();
	}
}