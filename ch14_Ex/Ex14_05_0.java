import java.util.*;
import java.util.stream.*;

// 스트림 생성 실습

public class Ex14_05_0 {
	public static void main(String[] args) {
		/*Collection -> Stream*/
		List<Integer> list = Arrays.asList(1,2,3,4,5); //Arrays의 static 메서드. 배열을 list로
		Stream<Integer> intStream = list.stream(); //list를 stream으로.
//		intStream.forEach(i -> System.out.print(i) ); //foreach : stream의 메서드. 각 원소에 대해 수행.
		intStream.forEach(System.out::print);  //람다식 -> 메서드참조
		
		
		
		/*배열 -> Stream*/
		Stream<String> strStream = Stream.of("a", "b", "c");
		// Stream.of(new String[] {"a", "b", "c}); 
		// Arrays.stream(strArr); 와도 같다.
		
		// String배열 초기화 두가지 방법.
		// String[] strArr = {"a", "b", "c"};
		// String[] strArr = new String[] {"a", "b", "c"};
		
		int[] intArr = {1,2,3,4,5};
		IntStream intStream1 = Arrays.stream(intArr);
		intStream1.forEach(System.out::println);
		//System.out.println("count="+intStream1.count()); 최종연산.
		//System.out.println("sum="+intStream1.sum());
		//System.out.println("average="+intStream1.average());
		//객체 Stream이 아닌 기본형 Stream(intStream, LongStream 등등)은 sum, average등 제공.
		
		
		
		/*난수 스트림*/
		//IntStream intStream2 = new Random().ints(); //Random 클래스 생성자 및 ints 메서드. 무한 스트림으로반환.
		//IntStream intStream2 = new Random().ints(5);  //개수 5개로 지정.	
		IntStream intStream2 = new Random().ints(10, 5, 10);  //개수(10) 및 범위(5~10) 지정.	
		intStream2.limit(5).forEach(System.out::println);
		
		
		
		/*람다식 이용 스트림*/
		//iterate(a,b) : 이전요소에 종속적.a에서 시작. b의 람다식 수행.
		Stream<Integer> intStream3 = Stream.iterate(1, n -> n+2);
		intStream3.limit(10).forEach(System.out::println); //1 3 5 7 ...
		
		//generate(a) : 이전요소에 독립적. a만 수행.
		Stream<Integer> intStream4 = Stream.generate(()->1);
		intStream4.limit(10).forEach(System.out::println); // 1 1 1 1 ...
		
		
		
	}

}
