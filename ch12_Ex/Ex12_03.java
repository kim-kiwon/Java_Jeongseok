import java.util.*;

class Fruit implements Eatable {
	public String toString() { return "Fruit";}
}
class Apple extends Fruit { public String toString() { return "Apple";}}
class Grape extends Fruit { public String toString() { return "Grape";}}
class Toy				  { public String toString() { return "Toy"	 ;}}

interface Eatable {}

public class Ex12_03 {
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>(); //FruitBox는 지네릭스제한으로 Fruit의 자손들 지네릭스로 지정가능.
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
		//FruitBox<Grape> grapeBox = new FruitBox<Apple>(); 에러. 참조변수와 생성자 지네릭스 타입 불일치. 항상 같아야함.
		//FruitBox<Toy> toyBox = new FruitBox<Toy>(); Fruit 박스는 Toy 지네릭스로 못씀. 지네릭스 제한으로 Fruit 자손만 가능.
		Box<Toy> toyBox2 = new Box<Toy>(); //box는 가능. box는 제약조건이 없다.
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple()); // Apple은 Fruit의 자손.
		fruitBox.add(new Grape());
		
		appleBox.add(new Apple());
		
		grapeBox.add(new Grape());
		
		System.out.println("furitBox-"+fruitBox);
		System.out.println("furitBox-"+appleBox);
		System.out.println("furitBox-"+grapeBox);
	}
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {}
//FruitBox 클래스.
//지네릭스 제한: Fruit과 Eatable의 자손들. (인터페이스도 extends사용. 복수시 &)
//지네릭스는 아무 객체나 가능. 대신 그 객체만 들어올 수 있게 제한.
//그 지네릭스 설정에 제한을 두어 특정 개체만 지네릭스가 될 수 있게. 그것을 여기선 Fruit의 자손으로 지정한것.
//Box를 상속받음.

class Box<T> { //ArrayList를 내부에 갖는 클래스 Box. 메서드들도 갖음.
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); }
	T get(int i)     { return list.get(i);}
	int size()       { return list.size();}
	public String toString() { return list.toString();}
}
