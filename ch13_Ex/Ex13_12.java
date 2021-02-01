//동기화x 예제. 
//한 쓰레드가 출금하기 직전. 다른 쓰레드가 출금.
//계좌가 음수가 될 수 있다.
public class Ex13_12 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx12();
		new Thread(r).start();
		new Thread(r).start();
	}
}

class Account {
	private int balance = 1000;
	
	public int getBalance() { 
		return balance;
	}
	
	public void withdraw(int money) {
		if(balance >= money) {
			try { Thread.sleep(1000);} catch(InterruptedException e) {}
			balance -= money;
		}
	}
}

class RunnableEx12 implements Runnable {
	Account acc = new Account();
	
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance:" + acc.getBalance());
		}
	}
}