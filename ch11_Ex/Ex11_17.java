import java.util.*;

public class Ex11_17 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("김자바", 90);
		map.put("김자바", 100);
		map.put("이자바", 100);
		map.put("강자바", 80);
		map.put("안자바", 90);
		
		Set set = map.entrySet(); //set는 Hash map의 entrySet
		Iterator it = set.iterator(); //it는 entrySet의 iterator.
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next(); //Map.Entry는 Map인터페이스 내부의 Entry 인터페이스.
			              //하나의 Entry를 가리키기 위해 자료형으로 사용.
			System.out.println("이름 :" + e.getKey() + ", 점수 :" + e.getValue());
			//e에서 getKey와 getValue를 통해 각 엔트리의 key와 value를 가져올 수 있다.
		}
		//map에는 iterator가 없기에 set으로 변경하여 iterator 적용시키는 부분.
		
		set = map.keySet();
		System.out.println("참가자 명단 : " + set);
		
		Collection values = map.values(); //values는 중복 가능. 참조변수 Collections으로.
		it = values.iterator();
		
		int total = 0;
		
		while(it.hasNext()) {
			int i = (int)it.next();
			total += i;
		}
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/set.size());
		System.out.println("최고점수 : " + Collections.max(values)); //Collections에 max, min 존재.
		System.out.println("최저점수 : " + Collections.min(values));

	}

}
