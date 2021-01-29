import java.util.*;

public class Ex11_13 {

	public static void main(String[] args) {
		//Set set = new HashSet(); hashset은 정렬필요.
		Set set = new TreeSet(); //Treeset 자동 정렬됨.
		
		for(int i = 0; set.size() < 6; i++) {
			int num = (int)(Math.random()*45) + 1;
			set.add(num);
		}
		System.out.println(set);

	}

}
