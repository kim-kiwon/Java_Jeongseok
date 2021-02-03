//스트림 최종연산자. forEach, allMatch, reduce 등 실습.

import java.util.*;
import java.util.stream.*;

public class Ex14_09 {

	public static void main(String[] args) {
		String[] strArr = {
				"Inheritance", "Java", "Lambda", "stream",
				"OptionalDouble", "IntStream", "count", "sum"
			};

			//Stream.of(strArr).forEach(System.out::println); 직렬처리
			Stream.of(strArr).parallel().forEachOrdered(System.out::println); //병렬처리(Parallel) + 순서보정(forEachOrdered)

			boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==0); //길이가 0이 아닌것 있나.
			Optional<String> sWord = Stream.of(strArr)
						               .filter(s->s.charAt(0)=='s').findFirst(); //조건 맞는 첫번째값. parrel+findany 조합시 조건맞는 아무거나.

			System.out.println("noEmptyStr="+noEmptyStr);
			System.out.println("sWord="+ sWord.get());
			
			// Stream<String>을 Stream<Integer>로 변환.
			// map사용시 객체로. mapToInt 사용시 기본형으로 가능. 성능 향상.
			//Stream<Integer> intStream1 = Stream.of(strArr).map(String::length);
			
			// Stream<String>을 IntStream으로.
			IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
			IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
			IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
			IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

			int count = intStream1.reduce(0, (a,b) -> a + 1); //reduce : 누적연산. 람다식이용 개수 반환.
			int sum   = intStream2.reduce(0, (a,b) -> a + b); //(a,b)에서 a : 반환값. b : b번째 객체.
			
			OptionalInt max = IntStream.empty().reduce(Integer::max);
			OptionalInt min = intStream4.reduce(Integer::min);
			System.out.println("count="+count);
			System.out.println("sum="+sum);
			//System.out.println("max="+ max.getAsInt()); //nullException 발생가능.
			System.out.println("max="+ max.orElse(0)); // null일시 0 반환하도록 처리
			System.out.println("min="+ min.getAsInt());
	}

}
