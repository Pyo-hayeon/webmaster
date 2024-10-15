package chap07_exam;

public class PCMain {
	public static void main(String[] args) {
		Parent parent = new Child();
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		
		//사용불가 자식이 부모로 자동 타입변환되어서 오버라이딩된 자식메소드 아니면 못씀
//		parent.field2 = "data2";
//		parent.method3();
		
		//부모화된 자식을 강제로 자식으로 만들어서 다시 메소드 사용할수 있
		Child child = (Child) parent;
		child.field2 = "data2";
		child.method3();
		
	}
}
