import java.util.*;

public class Ex11_15 {

	public static void main(String[] args) {
		//TreeSet은 rangeSearch에 매우 유리.
		TreeSet set = new TreeSet(); //headSet, tailSet 등은 TreeSet의 메서드. 따라서 참조변수는 Set으로 못한다.
		int[] score = {80, 95, 50, 35, 45, 65, 10, 100};
		
		for(int i = 0; i < score.length; i++)
			set.add(new Integer(score[i]));
		
		System.out.println("50보다 작은 값 :" + set.headSet(50)); //50의 왼쪽 가지 전체.
		System.out.println("50보다 큰 값 :" + set.tailSet(50)); //50의 왼쪽가지 제외 값.
		System.out.println("40과 80사이의 값 :" + set.subSet(40, 80)); //40의 오른쪽 이면서 80의 왼쪽가지.
	}

}
