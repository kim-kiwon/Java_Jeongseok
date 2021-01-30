class Parent {
	void parentMethod() {}
}

class Child extends Parent {
	@Override //애너테이션 사용. 오버라이딩을 하였다고 컴파일러에게 정보 전송.
	void parentMethod() {}
}