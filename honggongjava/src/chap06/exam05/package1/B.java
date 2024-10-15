package chap06.exam05.package1;

public class B {
	//필드
	//생성자
	public B() {
		A a = new A();
		a.field1 = 1;
		a.field2 = 1;
		//a.field3 = 1;	// <- privte 여서 접근 불가
		
		a.method1();
		a.method2();
		//a.method3();	// <- privte 여서 접근 불가
	}
	//메소드
}
