package chap06.exam03.package1;

//접근제한자가 없어 default로 처리됨
// 동일 패키지 내에서만 사용가능
public class A {
	//필드
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	//생성자
	A(){}
	public A(boolean a){}
	A(int a){}
	private A(String a){}
	
	//메소드
}
