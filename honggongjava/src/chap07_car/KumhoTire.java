package chap07_car;

public class KumhoTire extends Tire{
	//필드
	//생성자
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;	//누적 회전수 1증가
		
		//누적회전수가 수명보다 작으면 타이어 수명 호출 // 수명다하면 타이어 펑크
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "금호타이어 수명: "+ (maxRotation - accumulatedRotation) + "회");
			return true;
		}else {
			System.out.println("***" + location + " 금호타이어 펑크***");
			return false;
		}
	}
}
