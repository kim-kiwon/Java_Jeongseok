import java.util.*;

class Fruit2 {public String toString() { return "Fruit";}}
class Apple2 extends Fruit2 {public String toString() { return "Apple";}}
class Grape2 extends Fruit2{public String toString() { return "Grape";}}
//Fruit2의 자손인 Apple2와 Grape2

class Juice {
	String name;
	
	Juice(String name) {this.name = name + "Juice";}
	public String toString() { return name; }
}

class Juicer {
	static Juice makeJuice(FruitBox2<? extends Fruit2> box) { //메서드 매개변수에 와일드카드. 매개변수로 Fruit2의 자손만 가능. (제한 느낌) 매개변수 자료형은 FruitBox2
		String tmp = "";
		
		for(Fruit2 f : box.getList())
			tmp += f + " ";
		return new Juice(tmp);
	}
}

public class Ex12_04 {
	public static void main(String[] args) {
		FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>(); //지네릭스 제한으로 지네릭스는 Fruit2 자손만 가능. 
		FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>(); //Apple2 는 자손이라 지네릭스로 가능.
		FruitBox2<? extends Fruit2> appleBox2 = new FruitBox2<Apple2>(); //와일드 카드이용. 지네릭 타입 불일치 함에도 가능. 객체 지네릭이 참조변수 지네릭 자손이므로.
		fruitBox.add(new Apple2());
		fruitBox.add(new Grape2());
		appleBox.add(new Apple2());
		appleBox.add(new Apple2());
		
		System.out.println(Juicer.makeJuice(fruitBox)); //와일드카드에 따라 매개변수로 FruitBox2<Fruit2자손> 꼴만 가능.
		System.out.println(Juicer.makeJuice(appleBox));
	}
}

class FruitBox2<T extends Fruit2> extends Box2<T> {} //FruitBox2 클래스. Box2를 상속받으며. 지네릭스 제한으로 지네릭스는 Fruit2의 자손만 가능.

class Box2<T> { //Box2 클래스. 지네릭스해 자료형 구현된 지네릭 클래스.
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); }
	T get(int i) { return list.get(i); }
	ArrayList<T> getList() {return list;}
	int size() {return list.size(); }
	public String toString() { return list.toString();}
}

//정리.
//지네릭 클래스. 지네릭 메서드. 와일드 카드.
//지네릭 클래스와 메서드는 클래스와 메서드 호출 시 내부 변수를 원하는 자료형으로 변경해주기 위한것. 
//와일드 카드의 원 목적은 참조변수와 인스틴스의 지네릭을 다르게 사용할 수 있게 하기 위함.
//지네릭 제한은 지네릭 클래스와 메서드에 들어오는 자료형에 제한을 두는 것.