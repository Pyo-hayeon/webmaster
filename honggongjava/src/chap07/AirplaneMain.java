package chap07;

public class AirplaneMain {
	public static void main(String[] args) {
		AirplaneSom ap = new AirplaneSom();
		
		ap.takeoff();
		//오버라이딩 했지만 부모클래스 메소드 호출
		ap.fly();
		
		ap.flyMode = ap.SUPERSONIC;
		//오버라이딩에 의한 자식메소드 호출
		ap.fly();
		
		ap.land();
		
	}
}
