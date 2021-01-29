import java.util.*;

public class Ex11_03 {
	public static void main(String[] args) {
		
		Stack st = new Stack(); //스택 생성.
		String expression = "((3+5)*8-2)"; //식 생성
		System.out.println("expression: " + expression);
		
		try {
			for (int i = 0; i < expression.length(); i++) {
				char ch = expression.charAt(i);
				
				if(ch == '(') { ///여는 괄호면 스택에 "" 삽입.
					st.push(ch + "");
				} else if (ch == ')') { //닫는 괄호면 스택에서 pop으로 삭제.
					st.pop();
				}
			}
			
			if(st.isEmpty()) { //다 끝나고 비어있으면 괄호가 올바른것.
				System.out.println("괄호가 일치합니다.");
			} else {
				System.out.println("괄호가 일치하지 않습니다.");
			}
		} catch (EmptyStackException e) { //중간에 비어있는 스택에서 pop을 수행하면 올바르지 않은것. 예외처리.
			System.out.println("괄호가 일치하지 않습니다.");
		}
	}

}
