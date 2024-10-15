package chap07;

public class CalculatorSom extends Calculator {
	//메소드
	//부모와 메소드 타입, 이름, 매게변수 목록이 같음
	//오버라이딩
	double areaCircle(double r) {
		System.out.println("자식클래스");
		return Math.PI * r * r;
	}
}
