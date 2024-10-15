package chap06.exam06;

public class CarMain {

	public static void main(String[] args) {
		//기본생성자로 객체 생성
		Car car1 = new Car();
		
		//현재 속력 //초기화없어 기본값 0 출력
		System.out.println(car1.getSpeed());
		
		//현재속력 변경 메소드 호출 -50 로 변경
		car1.setSpeed(-50);
		//하지만 -속력은 0으로 보정
		System.out.println(car1.getSpeed());
		
		car1.setSpeed(60);
		System.out.println(car1.getSpeed());
		
		//false가 아니면 => true가 되어서 조건이 실행
		//자동차를 멈춤
		if(!car1.isStop()) {
			car1.setStop(true);
		}
		
		System.out.println(car1.getSpeed());
		
	}

}
