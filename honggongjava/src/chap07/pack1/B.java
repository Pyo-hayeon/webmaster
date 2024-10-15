package chap07.pack1;

public class B {
	//동일 패키지 호출 가능
	public void mothod() {
		A a = new A();
		a.field = "aaa";
		a.method();
	}
}
