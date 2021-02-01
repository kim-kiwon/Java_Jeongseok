public class Ex13_08 { //main쓰레드
	public static void main(String[] args) {
		ThreadEx8_1 th1 = new ThreadEx8_1();
		ThreadEx8_2 th2 = new ThreadEx8_2();
		th1.start(); th2.start();
		
		/*
		try {
			//th1.sleep(2000); 이렇게해도 main쓰레드가 sleep. (sleep이 static 메서드이므로)
			Thread.sleep(2000);
		} catch(InterruptedException e) {}
		*/
		
		delay(2 * 1000); //함수로 생성. 
		                 //마찬가지로 main쓰레드가 sleep 된다.
		System.out.print("<<main 종료>>");
	}
	
	static void delay(long millis) {
		try { 
			Thread.sleep(millis);
		} catch(InterruptedException e) {}
	}
}

class ThreadEx8_1 extends Thread { //th1 쓰레드
	public void run() {
		for(int i = 0; i < 300; i++) System.out.print("-");
		System.out.print("<<th1 종료>>");
	} //run()
}

class ThreadEx8_2 extends Thread { //th2 쓰레드
	public void run() {
		for(int i = 0; i < 300; i++) System.out.print("|");
		System.out.print("<<th2 종료>>");
	} //run()
}
