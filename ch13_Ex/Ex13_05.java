import javax.swing.JOptionPane;

//멀티쓰레드의 경우 한 쓰레드 입출력시 다른 쓰레드 수행 가능
public class Ex13_05 {
	public static void main(String[] args) {
		
		Runnable r = new ThreadEx5_1();
		Thread th1 = new Thread(r);
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
		System.out.println("입력하신 값은" + input + "입니다.");
		
	}
}

class ThreadEx5_1 implements Runnable {
	public void run() {
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); //1초 시간 지연
			} catch(Exception e) {}
		}
	}
}