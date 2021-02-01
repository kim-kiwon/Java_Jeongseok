public class Ex13_02 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
	
		for(int i = 0; i < 300; i++)
			System.out.printf("%s", new String("-"));
		
		System.out.print("소요시간1:" + (System.currentTimeMillis() - startTime));
		
		for(int i = 0; i < 300; i++)
			System.out.printf("%s", new String("|"));
		
		System.out.print("소요시간2:"+(System.currentTimeMillis()- startTime));
		
		//싱글쓰레드의 작업. 두 작업이 순차적으로 수행됨
	}
}
