// 스트림 중간연산 중 map 이용 내부요소 변환하기.

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Ex14_06 {
	public static void main(String[] args) {
		File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"),
				new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")
		};
		
		Stream<File> fileStream = Arrays.stream(fileArr);
		
		Stream<String> filenameStream = fileStream.map(File::getName); //파일의 이름으로 fileStream 변경.
		filenameStream.forEach(System.out::println);
		
		fileStream = Stream.of(fileArr);
		
		fileStream.map(File::getName) //File -> String
		.filter(s -> s.indexOf('.') != -1) //. 없는 문자열 제거
		.peek(s->System.out.printf("filename=%s%n", s)) //peek 이용 스트림 중간중간 요소 출력 가능. 
		.map(s -> s.substring(s.indexOf('.')+1)) // 문자열들이 . 이후만 저장하도록
		.peek(s->System.out.printf("extension=%s%n", s))
		.map(String::toUpperCase) // 대문자로 변경
		.distinct() //중복제거
		.forEach(System.out::print);
	}

}
