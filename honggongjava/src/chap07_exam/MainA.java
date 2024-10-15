package chap07_exam;

class A{}

class B extends A{}
class C extends A{}

class D extends B{}
class E extends B{}

class F extends C{}


public class MainA {
	public static void main(String[] args) {
		//B b = new B();
		//원래 이게 안되야할껀데 강제타입변환이라서 // 부모로는 자동 타입변환인데 되네
		B b = (B) new A();
		//B b = new D();
		//B b = new E();
	}
}
