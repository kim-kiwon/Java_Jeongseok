public class Ex13_03 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		Runnable r = new ThreadEx3_1();
		Thread th1 = new Thread(r);
		th1.start();
		startTime = System.currentTimeMillis();
		
		for(int i = 0; i< 300; i++)
			System.out.printf("%s", new String("-"));
		
		System.out.printf("소요시간1: " + (System.currentTimeMillis() - Ex13_03.startTime));
	}

}

class ThreadEx3_1 implements Runnable {
	public void run() {
		for(int i = 0; i < 300; i++)
			System.out.printf("%s", new String("|"));
		
		System.out.print("소요시간2:" + (System.currentTimeMillis() - Ex13_03.startTime));
	}
}