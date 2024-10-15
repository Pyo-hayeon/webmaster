package chap07_car;

public class Tire {
	//필드
	public int maxRotation;	//최대 회전수 (수명)
	public int accumulatedRotation;	//누적 회전수
	public String location;	//타이어 위치
	
	//생성자
	//타이어 위치와, 수명을 초기화 하는 생성자
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	//메소드
	public boolean roll() {
		++accumulatedRotation;	//누적 회전수 1증가
		
		//누적회전수가 수명보다 작으면 타이어 수명 호출 // 수명다하면 타이어 펑크
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "Tire 수명: "+ (maxRotation - accumulatedRotation) + "회");
			return true;
		}else {
			System.out.println("***" + location + " 타이어 펑크***");
			return false;
		}
	}
	
}
