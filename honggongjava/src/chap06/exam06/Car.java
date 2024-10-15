package chap06.exam06;

public class Car {
	//필드
	private int speed;
	private boolean stop;
	
	//생성자
	
	//메소드
	//현재 속도를 반환해주는 메소드
	public int getSpeed() {
		return speed;
	}
	
	//외부로부터 값을 받아서 속도를 변환해주는 메소드
	public void setSpeed(int speed) {
		//받아온 값이 음수일경우엔 속도를 0으로 보정해줌
		if(speed<0) {
			this.speed = 0;
		}else{
			this.speed = speed;
		}
	}
	
	//호출시 차량을 멈추기 위해서 사용
	public boolean isStop() {
		//stop는 변수 현재 기본값 false가 들어있음
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}
}
