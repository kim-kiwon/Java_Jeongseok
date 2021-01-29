enum Direction {EAST, SOUTH, WEST, NORTH }; //하나하나가 객체.
//열거형. 순서대로 0, 1, 2, 3 에 해당하는 숫자 부여.
//순서와 다른 상수를 부여할 수도 있음.

public class Ex12_05 {
	public static void main(String[] args) {
		Direction d1 = Direction.EAST; //주로 이 방법을 사용.
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Direction.valueOf(Direction.class, "EAST");
		
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		System.out.println("d3="+d3);
		
		System.out.println("d1==d2? " + (d1==d2));
		System.out.println("d1==d3? " + (d1==d3));
		System.out.println("d1.equals(d3)? " + d1.equals(d3));
		System.out.println("d1.compareTo(d3)? " + d1.compareTo(d3)); //compareTo는 같으면 0. 작으면 음수. 크면 양수 반환.
		System.out.println("d1.compareTo(d2)? " + d1.compareTo(d2));
		//enum이 객체라서 equals와 compareTo 쓰는것.
		
		Direction[] dArr = Direction.values(); //모든 상수를 배열로 저장.
		
		for(Direction d : dArr)
			System.out.printf("%s=%d%n", d.name(), d.ordinal()); //name : 값. ordinal : 순서.
	}

}
