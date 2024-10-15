package chap06;

public class CarMain {

	public static void main(String[] args) {
		//기본 생성자 연습
		
		//이렇개 객체를 생성하면 [기본생성자]
		//클래스에 생성자가 없어도 된다
		Car myCar = new Car();
		
		System.out.println("제작회사: "+myCar.company);
		System.out.println("모델명: "+myCar.model);
		System.out.println("색깔: "+myCar.color);
		System.out.println("최고속도: "+myCar.maxSpeed);
		System.out.println("현재속도: "+myCar.speed);
		
		//객체 필드 값 변경
		myCar.speed = 60;
		System.out.println("수정된 속도: "+myCar.speed);

		//교재 279페이지
		myCar.setGas(5);
		
		boolean gasState = myCar.isLeftGas();
		if(gasState) {
			System.out.println("출발합니다");
			myCar.run();
		}
		
		if(myCar.isLeftGas()) {
			System.out.println("gas 주입할 필요 없음");
		}else {
			System.out.println("gas 주입하세요");
		}
		
		
		//교재 284페이지
		myCar.keyTurnOn();
		myCar.run2();
		
		int speed = myCar.getSpeed();
		System.out.println("현재 속도 : "+speed+"km/h");
		
	}

}
