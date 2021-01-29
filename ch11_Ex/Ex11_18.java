import java.util.*;

public class Ex11_18 {
	public static void main(String[] args) {
		String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"}; //data 배열. 문자입력.
		
		HashMap map = new HashMap();
		
		for(int i = 0; i < data.length; i++) { //data배열 돌면서.
			if(map.containsKey(data[i])) {  //해당 원소가 key로서 map에 존재하는지 확인.
				int value = (int)map.get(data[i]); //있다면. 해당 문자를 key로 갖는 value값 가져옴.
				map.put(data[i], value + 1); // 그 value값 1 증가해서 map에 재삽입.
			} else {
				map.put(data[i], 1); //해당 원소가 key로서 map에 없다면 삽입.
			}
		}
		
		Iterator it = map.entrySet().iterator(); //it는 map의 entrySet의 iterator.
		
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next(); // Map.Entry 자료형. map의 entry 하나하나를 가리킴.
			int value = (int)entry.getValue();
			System.out.println(entry.getKey() + " : "
										+ printBar('#' , value) + " " + value );
		}
	}
	
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		
		for(int i = 0; i < bar.length; i++)
			bar[i] = ch;
		
		return new String(bar);
	}
}
