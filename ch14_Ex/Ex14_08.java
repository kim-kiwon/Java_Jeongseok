//optional의 연산들. map,get,filter,ifPresent 등
import java.util.*;

public class Ex14_08 {
	public static void main(String[] args) {
		Optional<String>  optStr = Optional.of("abcde");
//		Optional<Integer> optInt = optStr.map((s) -> s.length());
		Optional<Integer> optInt = optStr.map(String::length);

		System.out.println("optStr="+optStr.get()); //abcde
		System.out.println("optInt="+optInt.get()); //5(길이)

		int result1 = Optional.of("123") //result1 = 123
						    .filter(x->x.length() >0) //123길이 3이므로 통과.
						    .map(Integer::parseInt).get(); // Integer123으로.

		int result2 = Optional.of("") //result2 = 빈문자열.
						    .filter(x->x.length() >0) // 길이 = 0 이므로 null이됨.
						    .map(Integer::parseInt).orElse(-1); // null이라 orElse로가서 -1반환.

		System.out.println("result1="+result1);
		System.out.println("result2="+result2);

		Optional.of("456").map(Integer::parseInt) //456으로
					      .ifPresent(x->System.out.printf("result3=%d%n",x)); //null 아니므로(isPresent) 출력.

		OptionalInt optInt1  = OptionalInt.of(0);   //0
		OptionalInt optInt2  = OptionalInt.empty();  //빈 객체

		System.out.println(optInt1.isPresent());  //true
		System.out.println(optInt2.isPresent());   //false

		System.out.println(optInt1.getAsInt()); //0
//		System.out.println(optInt2.getAsInt()); //빈 객체를 get으로 반환시 에러발생.
		System.out.println("optInt1="+optInt1);
		System.out.println("optInt2="+optInt2);
	  	System.out.println("optInt1.equals(optInt2)?"+optInt1.equals(optInt2)); //빈것과 0은 다르다.
	}
}
