package chap07;

class A{}

class B extends A{}
class C extends A{}

class D extends B{}
class E extends C{}

public class PromotionExample {
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		//모두 최상위 부모는 A 여서 타입변환이됨
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		//각 부모들은 타입변환이됨
		B b1 = b;
		C c1 = e;
		
		//각 부모 상속도 아니고 서로 다른 남남 관계는 자동타입변환 안됨
		//B b3 = e;
		//C c2 = d;
		
	}
}
