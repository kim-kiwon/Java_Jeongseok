//함수형 인터페이스를 참조변수로 하는 람다식
@FunctionalInterface
interface MyFunction { //함수형 인터페이스 MyFunction
	void run(); //추상메서드 run.
}

public class Ex14_01 {
	static void execute(MyFunction f) { //함수형 인터페이스를 매개변수로 받아 run을 실행시키는 execute
		f.run();
	}

	static MyFunction getMyFunction() {  // getMyFunction 함수 : 람다식으로 구현하고. 함수형 인터페이스를 반환.
		MyFunction f = () -> System.out.println("f3.run()"); 
		return f;
	}
	
	public static void main(String[] args) {
		MyFunction f1 = () -> System.out.println("f1.run()"); //f1 람다식으로 구현
		
		MyFunction f2 = new MyFunction() { //f2 익명클래스로 구현
			public void run() {
				System.out.println("f2.run()");
			}
		};
		
		MyFunction f3 = getMyFunction(); //getMyFunction에서 람다식으로 구현된 인터페이스를 반환받아 f3에 저장.
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute( ()-> System.out.println("run()"));
	}
	
}
