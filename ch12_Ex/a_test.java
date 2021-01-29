import java.util.*;

public class a_test {
	public static void main(String[] args) {
		/*
		지네릭스 없는 경우.
		
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(20);
		list.add("30"); //list에 String형 입력 가능.
		
		Integer i = (Integer)list.get(2); //list.get 반환형 Object. Integer로 변환한다. ->컴파일 까지는 문제 X
		                                  //But 실행시 형변환 에러 발생.
		                                  //아예 Integer만 저장할 수 있게 해서 문제 막자.
		
		System.out.println(list);
		*/
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		//여러 종류 객체 넣으려면 <Object> 로. 모든 객체 부모이므로.
		//ArrayList<E>와 같은 지네릭 클래스에는 반드시 지네릭스 작성할 것.
		list.add(10);
		list.add(20);
		list.add(30); //지네릭스 덕분에 입력에 타입체크 강화.
		
		Integer i = list.get(2); //get 반환형 Object. Integer 형변환 필요.
		                         //But 지네릭스 지정으로 Integer 인거 암. 형변환 생략 가능.
		System.out.println(list);
		
	}

}
