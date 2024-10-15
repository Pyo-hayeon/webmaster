package chap07;

public class Car2Som {
	public int speed;
	
	public void speedUp() {
		speed += 1;
	}
	
	//다른데서 호출 할수는 있지만
	//상속받아서 오버라이딩은 불가능함
	public final void stop() {
		System.out.println("자동차 멈춤");
		speed = 0;
	}
}
