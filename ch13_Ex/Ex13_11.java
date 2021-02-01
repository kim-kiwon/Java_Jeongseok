public class Ex13_11 {
	static long startTime = 0;
	public static void main(String[] args) {
		Runnable r1 = new ThreadEx11_1();
		Runnable r2 = new ThreadEx11_2();
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();
		
		try {
			th1.join(); //main쓰레드가 th1의 작업이 끝날때 까지 대
			th2.join(); //main쓰레드가 th2의 작업이 끝날때 까지 대기
		} catch(InterruptedException e) {}
		
		System.out.print("소요시간:" + (System.currentTimeMillis() - startTime));
		//메인이 문자출력하는 th1 th2이 작업이 끝나고 소요시간을 출력하게됨.
	}
}

class ThreadEx11_1 implements Runnable {
	public void run() {
		for(int i = 0; i < 300; i ++) {
			System.out.print("-");
		}
	}
}

class ThreadEx11_2 implements Runnable {
	public void run() {
		for(int i = 0; i < 300; i ++) {
			System.out.print("|");
		}
	}
}