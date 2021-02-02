import java.util.function.*;

//람다식을 더 간단히 하는 메서드 참조.
public class Ex14_04_2 {
	public static void main(String[] args) {
		//매개변수 없는 생성자. Supplier 사용. 추상메서드 : get
//		Supplier<MyClass> s = () -> new MyClass(); 
//		Supplier<MyClass> s = MyClass::new;
		
		//매개변수 1개인 생성자. Function 사용. 추상메서드 : apply
//		Function<Integer, MyClass> s = (i) -> new MyClass(i);
		Function<Integer, MyClass> s = MyClass::new;
		
		MyClass mc = s.apply(100);
		System.out.println(mc);
		System.out.println(s.apply(200).iv);
		
		//길이가 Integer만큼인. int형 배열 생성.
//		Function<Integer, int[]> f2 = (i) -> new int[i];
		Function<Integer, int[]> f2 = int[]::new;
		System.out.println(f2.apply(100).length);
	}

}

class MyClass {
	int iv;
	
	MyClass(int iv) {
		this.iv = iv;
	}
}