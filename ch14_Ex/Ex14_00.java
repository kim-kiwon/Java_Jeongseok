//람다식 예제
public class Ex14_00 {
	public static void main(String[] args) {
		//람다식이란?
		//익명객체에서 메서드 부분을 표현한것.
		
		
//		MyFunction obj = new MyFunction() {
//			public int max(int a, int b) { //오버라이딩 - 접근 제어자는 좁게 못바꿈.
//				                           //default가 public보다 좁다. public해줘야함.
//				return a > b? a:b;
//			}
//		};
		
		MyFunction2 f = (a,b) -> a > b ? a : b; //위의 익명개체를 람다식 이용 간편하게 구현한 것.
		
		int value = f.max(3, 5); //추상메서드 호출로 사용.
		System.out.println("value="+value);
	}
}

@FunctionalInterface //함수형 인터페이스 : 단 하나의 추상 메서드만 보유.
                     //애너테이션 넣을시 컴파일러가 체크해줌.
interface MyFunction2 {
	public abstract int max(int a, int b);
	//호출하기 위해 이름을 붙여주는 느낌.
}
