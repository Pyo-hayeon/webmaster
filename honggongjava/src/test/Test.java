package test;

public class Test {
	private int speed;
	private boolean stop;
	
	int getSpeed() {
		return speed;
	}
	void setSpeed(int speed) {
		if(speed < 0) {
			this.speed = 0;
			stop = false;
			return;
		}else {
			this.speed = speed;
		}
	}
	
	void go() {
		if(speed > 0) {
			stop = true;
			while(stop) {
				System.out.println("차가 달립니다 현재속력 : "+speed);
				speed -= 3;
				setSpeed(speed);
			}
			System.out.println("차가 달립니다 현재속력 : "+speed);
		}
	}
	
}
