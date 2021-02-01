import javax.swing.JOptionPane;

//싱글쓰레드의 경우 입출력시 작업 중단
public class Ex13_04 {
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
		System.out.println("입력하신 값은" + input + "입니다.");
		
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); //1초 시간 지연
			} catch(Exception e) {}
		}
	}

}
