package chap07_car;

public class CarMain {

	public static void main(String[] args) {
		//자동차를 만듬
		Car car = new Car();
		
		for(int i=1; i<=5; i++) {
			//자동차 달리게하고 수명다한거 있으면 false가 출력하면서
			//리턴값이 0이아닌 다른숫자 가져옴
			int problemLocation = car.run();
			
			switch (problemLocation) {
				case 1: {
					System.out.println("앞왼쪽 한국타이어로 교체");
					car.frontLeftTire = new HankookTire("앞왼쪽", 15); 
					break;
				}
				case 2: {
					System.out.println("앞오른쪽 금호타이어로 교체");
					car.frontRightTire = new KumhoTire("앞오른쪽", 13);
					break;
				}
				case 3: {
					System.out.println("뒤왼쪽 한국타이어로 교체");
					car.backLeftTire = new HankookTire("뒤왼쪽", 14);
					break;
				}
				case 4: {
					System.out.println("뒤오른쪽 금호타이어로 교체");
					car.backRightTire = new KumhoTire("뒤오른쪽", 17);
					break;
				}
			}
			System.out.println("--------------------------------");
			
		}

	}

}
