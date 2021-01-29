import java.util.*;
import static java.util.Collections.*; //Collections 클래스의 Static 메서드 사용하기 위함.

public class Ex11_19 {

	public static void main(String[] args) {
		List list = new ArrayList();
		System.out.println(list);
		
		addAll(list, 1, 2, 3, 4, 5);
		//Collections static 메서드. 뒤의 객체를 list에 추가.
		System.out.println(list);
		
		rotate(list, 2);
		//위치를 오른쪽 두칸씩 순환.
		System.out.println(list);
		
		swap(list, 0, 2);
		//인덱스 0과 2의 위치 변경.
		System.out.println(list);
		
		shuffle(list);
		//랜덤하게 섞음.
		System.out.println(list);
		
		sort(list, reverseOrder());
		//순서 거꾸로 정렬.
		System.out.println(list);
		
		sort(list); 
		//오름차순 정렬.
		System.out.println(list);
		
		int idx = binarySearch(list, 3);
		//3의 값을 갖는 인덱스의 위치 반환. 정렬된 리스트에만 가능.
		System.out.println("index of 3 = " + idx);
		
		System.out.println("max=" +max(list));
		System.out.println("min=" +min(list));
		System.out.println("min=" +max(list, reverseOrder()));
		//Collections에 max, min 등 정의돼있음.
		
		fill(list, 9);
		//리스트를 9로 채운다.
		System.out.println("list="+list);
		
		List newList = nCopies(list.size(), 2);
		//size 만큼의 리스트를 만들고. 모두 2로 채운다.
		System.out.println("newList=" +newList);
		
		System.out.println(disjoint(list, newList));
		//공통요소 있는지 판별. 
		
		copy(list, newList);
		//newList를 list에 복사.
		System.out.println("newList="+newList);
		System.out.println("list="+list);
		
		replaceAll(list, 2, 1);
		//2를 모두 1로 변경.
		System.out.println("list="+list);
		
		Enumeration e = enumeration(list);
		ArrayList list2 = list(e);
		
		System.out.println("list2="+list2);
	}

}
