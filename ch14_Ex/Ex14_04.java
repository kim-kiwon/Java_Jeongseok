//컬렉션 프레임워크의 메서드 중, 함수형 인터페이스를 매개변수로 하는 메서드
import java.util.*;

public class Ex14_04 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(); //생성자의 지네릭스 생략가능. <>
		for(int i = 0; i< 10; i++)
			list.add(i);
		
		//list 모든 요소 출력.
		list.forEach(i->System.out.print(i+","));
		System.out.println();
		
		//list에서 2또는 3의배수 제거.
		list.removeIf(x-> x%2 == 0 || x%3 == 0);
		System.out.println(list);
		
		//list 각 요소에 10 곱하기
		list.replaceAll(i->i*10);
		System.out.println(list);
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		//Map 모든요소 {k,v}꼴 출력.
		map.forEach((k, v) -> System.out.print("{" + k + "," + v + "},"));
		System.out.println();
	}

}
