package chap07;

public class CalculatorMain {

	public static void main(String[] args) {
		
		int r = 10;
		//자식 클래스 객체 변수 생성
		//자식 클래스에서 재정의 해서 사용함
		CalculatorSom cs = new CalculatorSom();
		System.out.println(cs.areaCircle(r));
		
		//부모 클래스 자체객체 생성해서 부모클래스 호출
		Calculator cs2 = new Calculator();
		System.out.println(cs2.areaCircle(r));
		
	}

}
