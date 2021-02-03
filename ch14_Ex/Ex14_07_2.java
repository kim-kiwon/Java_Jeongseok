import java.util.*;

//optional 생성 실습
public class Ex14_07_2 {
	public static void main(String[] args) {
		/*목표 : NullpointerException 예방하자.*/
//		int[] arr = null;
		int[] arr = new int[0]; 
		System.out.println("arr.length"+arr.length);
		
		
//		Optional<String> opt = null;
		Optional<String> opt = Optional.empty();
		System.out.println("opt="+opt);
//		System.out.println("opt="+opt.get()); opt가 null일때 get은 예외발생.
		String str = opt.orElse("EMPTY"); 
//		str = opt.orElseGet(()->new String());
		str = opt.orElseGet(String::new); //위와같음. 메서드참조
		opt = Optional.of("abc");
	}

}
