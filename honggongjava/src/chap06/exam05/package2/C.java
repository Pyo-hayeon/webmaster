package chap06.exam05.package2;

import chap06.exam05.package1.A;

public class C {
	public C() {
		A a = new A();
		a.field1 = 1;
		//a.field2 = 1;	// <- default 여서 접근 불가
		//a.field3 = 1;	// <- privte 여서 접근 불가
		
		a.method1();
		//a.method2();	// <- default 여서 접근 불가
		//a.method3();	// <- privte 여서 접근 불가
	}
}
