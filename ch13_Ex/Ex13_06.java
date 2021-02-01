public class Ex13_06 {
	public static void main(String[] args) {
		Runnable r1 = new ThreadEx6_1();
		Runnable r2 = new ThreadEx6_2();
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);
		
		th2.setPriority(7);
		
		System.out.println("Priority of th1(-) : " + th1.getPriority());
		System.out.println("Priority of th2(|) : " + th2.getPriority());
		th1.start();
		th2.start();
		
	}

}

class ThreadEx6_1 implements Runnable {
	public void run() {
		for(int i = 0; i< 300; i++) {
			System.out.print("-");
			for(int x = 0; x < 10000000; x++);
		}
	}
}

class ThreadEx6_2 implements Runnable {
	public void run() {
		for(int i = 0; i< 300; i++) {
			System.out.print("|");
			for(int x = 0; x < 10000000; x++);
		}
	}
}