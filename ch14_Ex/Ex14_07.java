import java.util.*;
import java.util.stream.*;

public class Ex14_07 {
	public static void main(String[] args) {
		Stream<String[]> strArrStrm = Stream.of(
			new String[]{"abc", "def", "jkl"},
			new String[]{"ABC", "GHI", "JKL"}
		);

//		Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream); //flatmap 이용 1차 stream으로

		strStrm.map(String::toLowerCase) //스트림 요소 모두 소문자로.
			   .distinct() // 중복제거
			   .sorted() // 정렬
			   .forEach(System.out::println);
		System.out.println();

		String[] lineArr = {
			"Believe or not It is true",
			"Do or do not There is no try",
		}; //단어 하나하나를 string요소인 stream 만들어보자
		//문자열로 구성된 배열(하나의 문장)의 배열. 즉 이차원 배열이됨.
		//여기서 map을 쓰면 스트림의 스트림됨. ->flatmap으로 일차원 스트림으로.
		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" +"))) //split(" +") : 하나 이상의 공백 기준 나누기
			.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		System.out.println();
	}
}