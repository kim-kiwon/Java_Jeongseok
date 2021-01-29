import java.util.*;

public class Ex11_09 {

	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
		Set set = new HashSet(); //Hashset 생성. 다형성. 부모인 set을 참조변수로. set의 메서드만 사용가능.
		
		for(int i = 0; i< objArr.length; i++) {
			set.add(objArr[i]); //objArr의 내용을 HashSet에 저장. 중복으로 실패시 false반환.
		}
		//HashSet은 중복 X 순서 X. 
		System.out.println(set);
		
		Iterator it = set.iterator();
		//Iterator로 내용 출력.
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
