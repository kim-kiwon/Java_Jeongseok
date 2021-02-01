public class Ex13_01 {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		
		//메인에 다 때려박으면 싱글쓰레드. 
		//Thread 상속 클래스나. Runnable 인터페이스 구현 클래스를 이용.
		//메인에서 객체 생성후 Start 해주면 멀티쓰레드 수행.
	}
}

class ThreadEx1_1 extends Thread { //1. Thread클래스를 상속해서 쓰레드 구현
	public void run() { //쓰레드가 수행할 작업 자성
		for(int i = 0; i < 5; i++) {
			System.out.println(getName()); //조상인 Thread의 getName() 호출.
		}
	}
}
	
class ThreadEx1_2 implements Runnable { //2. Runnable인터페스를 구현해서 쓰레드 구현
	public void run() { //쓰레드가 수행할 작업 작성.
		for(int i = 0; i < 5; i++) {
			// Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
			System.out.println(Thread.currentThread().getName());
		}
	}
}

