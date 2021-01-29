import java.util.*;

public class Ex11_07 {
	public static void main(String[] args) {
		String[] strArr = {"cat","Dog", "lion", "tiger"};
		
		Arrays.sort(strArr); //Comparator를 지정x. 객체에 구현된 기본 정렬기준인 Comparable에 따라 정렬.
		System.out.println("strArr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		//CASE ~~ : String 클래스에 존재하는 comparator. 자주쓰는 것 만들어놈.
		System.out.println("strArr=" + Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending()); //역순 정렬. Descending 이라는 Comparator를 구체화한 클래스를 넣는다.
		System.out.println("strArr=" + Arrays.toString(strArr));
		
	}
}

class Descending implements Comparator { //Comparator를 구체화한것.
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c1.compareTo(c2) * -1; //기본 정렬 기준에 -1을 곱해준다.
		}
		return -1;
	}
}
