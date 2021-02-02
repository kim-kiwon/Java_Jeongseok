//Predicate의 결합
import java.util.function.*;
public class Ex14_03 {
	public static void main(String[] args) {
		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i%2 == 0;
		Predicate<Integer> notP = p.negate();
		
		Predicate<Integer> all = notP.and(q.or(r)); //and or negate : Predicate가 갖는 default메서드들.
		System.out.println(all.test(150));
		
		String str1 = "abc";
		String str2 = "abc";
		
		Predicate<String> p2 = Predicate.isEqual(str1); //비교하는 Predicate 작성 -> Predicate 클래스의 static 메서드 isEqaul사용.
		boolean result = p2.test(str2); //test : 함수형 인터페이스 Predicate가 가진 하나의 추상메서드. 람다식을 수행.
		System.out.println(result);
	}

}
