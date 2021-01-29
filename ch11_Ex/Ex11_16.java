import java.util.*;

public class Ex11_16 {
	public static void main(String[] args) {
		HashMap map = new HashMap(); //HashMap 생성.
		map.put("myId", "1234"); //map.put으로 entry 삽입.
		map.put("asdf", "1111");
		map.put("asdf", "1234"); //키값 일치하는 엔트리 삽입은 기존 엔트리 삭제. 새로운 엔트리 생성.
		
		Scanner s = new Scanner(System.in); 
		
		while(true) {
			System.out.println("id와 password를 입력해주세요");
			System.out.print("id :");
			String id = s.nextLine().trim(); //id 입력 key
			
			System.out.print("password :");
			String password = s.nextLine().trim(); //비밀번호 입력. value
			System.out.println();
			
			if(!map.containsKey(id)) { //key값중 id값이 존재하는지 확인.
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
				continue;
			}
			
			if(!(map.get(id)).equals(password)) { //id값의 value와 입력한 password가 일치하는지 확인.
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			} else {
				System.out.println("id와 비밀번호가 일치합니다.");
				break;
			}
		}

	}

}
