import java.util.*;

public class Ex11_06 {
	public static void main(String[] args) {
		int[] arr = {0,1,2,4}; //1차원 배열
		int[][] arr2D = {{11,12,13}, {21,22,23}}; //2차원 배열
		
		System.out.println("arr="+Arrays.toString(arr)); //Arrays의 toString 메서드로 배열을 문자열로. [~].
		System.out.println("arr2D="+Arrays.deepToString(arr2D)); //2차원 이상 배열은 deepToString 사용.
		
		int[] arr2 = Arrays.copyOf(arr, arr.length); //arr의 길이만큼 arr를 deepcopy.
		int[] arr3 = Arrays.copyOf(arr,  3);
		int[] arr4 = Arrays.copyOf(arr,  7);
		int[] arr5 = Arrays.copyOfRange(arr, 2, 4);
		int[] arr6 = Arrays.copyOfRange(arr, 0, 7);
		
		System.out.println("arr2="+Arrays.toString(arr2));
		System.out.println("arr3="+Arrays.toString(arr3));
		System.out.println("arr4="+Arrays.toString(arr4));
		System.out.println("arr5="+Arrays.toString(arr5));
		System.out.println("arr6="+Arrays.toString(arr6));
		
		int[] arr7 = new int[5];
		Arrays.fill(arr7, 9); // fill 메서드. arr7을 9로 채운다. arr = [9,9,9,9,9]
		System.out.println("arr7="+Arrays.toString(arr7));
		
		Arrays.setAll(arr7,  i -> (int)(Math.random()*6)+1);
		System.out.println("arr7="+Arrays.toString(arr7));
	}

}
