package chap07;

public class AirplaneSom extends Airplane{
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	
	public int flyMode = NORMAL;
	
	@Override
	public void fly() {
		if(flyMode == SUPERSONIC) {
			System.out.println("음속비행중");
		}else {
			//부모 메소드 호출
			super.fly();
		}
	}
}
