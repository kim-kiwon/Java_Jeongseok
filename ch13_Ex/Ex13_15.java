import java.util.ArrayList;

class Customer2 implements Runnable {
	private Table2  table;
	private String food;

	Customer2(Table2 table, String food) {
		this.table = table;  
		this.food  = food;
	}

	public void run() {
		while(true) {
			try { Thread.sleep(100);} catch(InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			table.remove(food);
			System.out.println(name + " ate a " + food);
		} 
	}
}

class Cook2 implements Runnable {
	private Table2 table;
	
	Cook2(Table2 table) { this.table = table; }

	public void run() {
		while(true) {
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			try { Thread.sleep(10);} catch(InterruptedException e) {}
		} 
	}
}

class Table2 {
	String[] dishNames = { "donut","donut","burger" }; 
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		while(dishes.size() >= MAX_FOOD) { //cook : 테이블에 음식을 가득 채울때 까지 음식 만듦.
				String name = Thread.currentThread().getName();
				System.out.println(name+" is waiting.");
				try {
					wait(); // 음식 다 차면 cook쓰레드는 대기열로.
					Thread.sleep(500);
				} catch(InterruptedException e) {}	
		}
		dishes.add(dish);
		notify(); //음식 추가하고. 손님 하나 실행열로. 먹을 수 있게.
		System.out.println("Dishes:" + dishes.toString());
	}

	public void remove(String dishName) { //음식 먹기
		synchronized(this) {	
			String name = Thread.currentThread().getName();

			while(dishes.size()==0) {
					System.out.println(name+" is waiting.");
					try {
						wait(); //음식이 없으면 손님은 대기열로.
						Thread.sleep(500);
					} catch(InterruptedException e) {}	
			}

			while(true) {
				for(int i=0; i<dishes.size();i++) {
					if(dishName.equals(dishes.get(i))) { //원하는 음식일 경우
						dishes.remove(i); //음식 먹고
						notify(); // 혹시 요리사 대기열에 있다면 실행열로.
						return;
					}
				}

				try {
					System.out.println(name+" is waiting.");
					wait(); // 원하는 음식없는 손님 대기열로. (lock 풀어주기 위해)
					Thread.sleep(500);
				} catch(InterruptedException e) {}	
			} 
		} 
	}
	public int dishNum() { return dishNames.length; }
}

class Ex13_15 {
	public static void main(String[] args) throws Exception {
		Table2 table = new Table2();

		new Thread(new Cook2(table), "COOK").start();
		new Thread(new Customer2(table, "donut"),  "CUST1").start();
		new Thread(new Customer2(table, "burger"), "CUST2").start();
		Thread.sleep(2000);
		System.exit(0);
	}
}

//wait과 notify 결과 한 쓰레드가 lock을 오래쥐는 일이 없어져 효율성 올라감.
//문제 : 대기열에 손님 요리사 공존.
//notify가 random 하므로. 의도치 않은 사람 notify 될 수 있다.
//Lock & Condition 이용 구별하여 notify 가능.