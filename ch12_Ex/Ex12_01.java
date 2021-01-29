import java.util.*;

class Product {}
class Tv extends Product {}
class Audio extends Product {}
//Product의 자손 Tv Audio

public class Ex12_01 {
	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Tv> tvList = new ArrayList<Tv>();
		
		//ArrayList<Product> tvlist = new ArrayList<Tv>(); //에러. 지네릭스는 같아야함.
		//List<Tv> tvlist = new ArrayList<Tv>(); //가능. 다형성. List가 부모.
		
		productList.add(new Tv());
		productList.add(new Audio());
		
		tvList.add(new Tv());
		tvList.add(new Tv());
		
		printAll(productList);
		//printAll(tvList); //tvList : 지네릭스가 Tv형인 ArrayList. 지네릭스 불일치. 못들어간다.
	}
	//지네릭스 형은 반드시 일치(다형성 불가)
	//매개변수와 생성자의 자료형 자체는 다형성 가능.
	public static void printAll(ArrayList<Product> list) { //지네릭스가 Product인 ArrayList 형만.
		for (Product p : list) {
			System.out.println(p);
		}
	}
}
