package chap06.exam03.package1;

// A 클래스는 default 접근 제한자여서 동일 패키지 내에서는 호출가능
public class B {
	A a0 = new A();
	A a1 = new A(true);
	A a2 = new A(1);
	//private는 자기클래스 안에서만 호출할 수 있게 하기때문에
	//A a3 = new A("문자열");
	
}
