import java.util.*;

public class Ex11_08 {
	public static void main(String[] args) {
		Integer[] arr = {30, 50, 10, 40, 20};
		
		Arrays.sort(arr); //comparable
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr, new DescComp());
		System.out.println(Arrays.toString(arr));
	}
}
//객체 정렬하는 법.
//1. 정렬할 객체의 class에 Comparable 인터페이스의 compareTo 함수를 오버라이딩.
//2. Comparator의 compare 함수를 오버라이딩. 객체 자체를 인자로 넣어줌.
//a.compareTo(b) 는 a<b면 음수. a=b면 0. a>b면 양수를 리턴.
class DescComp implements Comparator {
	public int compare(Object o1, Object o2) {
		if(!(o1 instanceof Integer && o2 instanceof Integer))
			return -1;
		
		Integer i = (Integer)o1;
		Integer i2 = (Integer)o2;
		
		return i.compareTo(i2) * - 1;
	}
}