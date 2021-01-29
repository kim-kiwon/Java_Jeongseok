import java.util.*;

public class Ex11_04 {
	static Queue q = new LinkedList(); //queue 생성.
	static final int MAX_SIZE = 5; //queue의 최대 사이즈 = 5로
	
	public static void main(String[] args) {
		while(true) {
			System.out.print(">>");
			try {
				Scanner s = new Scanner(System.in); //입력을 받는다.
				String input = s.nextLine().trim(); //입력값을 input에 저장. trim은 앞뒤 공백을 삭제시킴.
				
				if("".equals(input)) continue; //null문자열이면 while문 다시반복.
				
				if(input.equalsIgnoreCase("q")) { //equalsIgnoreCase : 대소문자 구분 없이 비교.
					System.exit(0); 
				} else if(input.equalsIgnoreCase("help")) {
					System.out.println("help - 도움말을 보여줍니다.");
					System.out.println("q - 프로그램을 종료합니다.");
					System.out.println("history - 최근에 입력한 명령어를."
							+ MAX_SIZE + "개 보여줍니다.");
				} else if(input.equalsIgnoreCase("history")) { //history일경우 q 처음부터 다섯개 출력.
					int i = 0;
					save(input); //history도 큐에 저장.
					
					//Iterator 활용. 0부터 시작해서 다음이 존재하면 계속해서 큐의 다음원소 출력.
					LinkedList tmp = (LinkedList)q; //큐의 내용을 보여주기 위해. queue를 linkedlist로 형변환한 tmp 생성.
					//q는 참조변수는 queue지만 원래 객체는 linkedlist. 따라서 형변환 가능하다.
					ListIterator it = tmp.listIterator();
					
					while(it.hasNext())
						System.out.println(++i+"."+it.next());
				} else { //명령어가 아니면 저장.
					save(input);
					System.out.println(input);
				}
			} catch(Exception e) {
				System.out.println("입력오류입니다.");
			}
		}
	}
	public static void save(String input) {
		//save함수. 입력값 queue에 저장.
		//최대 크기 넘으면 제일 앞에거부터 삭제.
		if(!"".equals(input))
			q.offer(input);
		
		if(q.size() > MAX_SIZE)
			q.remove();
	}
}
