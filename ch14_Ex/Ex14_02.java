//java.util.function 패키지에서 제공하는 다양한 함수형 인터페이스.
import java.util.*;
import java.util.function.*;

public class Ex14_02 {
	public static void main(String[] args) {
		Supplier<Integer> s = ()-> (int)(Math.random()*100) + 1; // 1~ 100의 난수
		Consumer<Integer> c = i -> System.out.print(i+",");
		Predicate<Integer> p = i -> i % 2 == 0; //짝수인지 검사
		Function<Integer, Integer> f = i -> i / 10 * 10; // i의 일의 자리 없애기.
		
		List<Integer> list = new ArrayList<>(); //Arraylist 생성.
		makeRandomList(s, list);
		System.out.println(list);
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
	}
	
	//메서드들 매개변수로 미리 정의된 함수형 인터페이스를.
	static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i : list) {
			newList.add(f.apply(i));
		}
		
		return newList;
	}
	
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for(T i : list) {
			if(p.test(i))
				c.accept(i);
		}
		System.out.println("]");
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for(int i = 0; i< 10; i++) {
			list.add(s.get());
		}
	}
}
