public class Ex13_07 implements Runnable{ //main쓰레드에서 run 구현.
	static boolean autoSave = false;
	
	public static void main(String[] args) { //main쓰레드
		Thread t = new Thread(new Ex13_07()); //main쓰레드를 돕는 데몬쓰레드 t 생성.
		t.setDaemon(true); //t를 데몬쓰레드로.
		t.start();
		
		for(int i = 1; i <= 10; i++) { //main쓰레드 수행내용
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
			System.out.println(i);
			
			if(i == 5) autoSave = true;
		}
		
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void run() { //클래스 내부에서 run 구체화. 
		while(true) { //무한루프여도 일반쓰레드 모두 종료되면 자동종료.
			//데몬쓰레드 수행내용
			try {
				Thread.sleep(3 * 1000);
			} catch(InterruptedException e) {}
			
			if(autoSave) autoSave();
		}
	}
	
	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
}
