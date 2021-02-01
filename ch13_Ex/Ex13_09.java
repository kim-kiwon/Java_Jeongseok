import javax.swing.JOptionPane;

public class Ex13_09 {
	public static void main(String[] args) {
		ThreadEx9_1 th1 = new ThreadEx9_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
		//메인쓰레드 : 입력창 출력
		System.out.println("입력하신 값은 " + input + "입니다.");
		th1.interrupt(); //값을 입력하면 카운트다운 쓰레드 인터럽트.
		System.out.println("isInterrupted():" + th1.isInterrupted());
		//th1. 즉 카운트다운 쓰레드가 인터럽트 되어있는지를 반환
		
		System.out.println("interrupted():" + Thread.interrupted());
		//interrupted = 스태틱 메서드. 이 쓰레드(메인 쓰레드)가 인터럽트 되었는지 반환하고 false로 초기화.
	}

}

class ThreadEx9_1 extends Thread { //카운트다운 하는 쓰레드
	public void run() {
		int i = 10;
		
		while(i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x = 0; x < 2500000000L; x++);
		}
		System.out.println("카운트가 종료되었습니다.");
	}
}