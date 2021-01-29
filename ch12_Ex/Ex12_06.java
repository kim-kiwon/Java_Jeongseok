enum Direction2 {
	EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");
	
	private static final Direction2[] DIR_ARR = Direction2.values();
	//객체가 저장된 배열.
	
	private final int value;
	private final String symbol;
	//멤버변수들.
	
	Direction2(int value, String symbol) {
		this.value = value;
		this.symbol = symbol;
	}
	//enum 내부에 하나하나가 객체. 생성자.
	
	public int getValue() {return value; }
	public String getSymbol() { return symbol; }
	
	public static Direction2 of(int dir) {
		if(dir < 1 || dir > 4)
			throw new IllegalArgumentException("Invalid value :" + dir);
		return DIR_ARR[dir - 1];
	}
	//of 라는 메서드. 값 가져오도록.

	public Direction2 rotate(int num) {
		num = num % 4;
		
		if(num < 0) num += 4;
		
		return DIR_ARR[(value-1+num) % 4];
	}
	//현재값에서 회전한 값 가져오도록.
	
	public String toString() {
		return name()+getSymbol();
	}
}
public class Ex12_06 {

	public static void main(String[] args) {

	}

}
