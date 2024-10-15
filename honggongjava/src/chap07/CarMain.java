package chap07;

public class CarMain {

	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i=0; i<5; i++) {
			int problemLocation = car.run();
			switch (problemLocation) {
				case 1: {
					//부모타입으로 자동변환 //자식꺼 아무것도 못쓰죠 오버라이딩된 메소드만 자기꺼 쓸수있음
					car.fLt = new HankookTire(15, "앞왼쪽");
					System.out.println("타이어 교체");
					break;
				}
				case 2: {
					car.fRt = new HankookTire(13, "앞오른쪽");
					System.out.println("타이어 교체");
					break;
				}
				case 3: {
					car.bLt = new HankookTire(14, "뒤왼쪽");
					System.out.println("타이어 교체");
					break;
				}
				case 4: {
					car.bRt = new HankookTire(12, "뒤오른쪽");
					System.out.println("타이어 교체");
					break;
				}
				default: { break; }
				
			}
			System.out.println("--------------------");
			
		}

	}

}
