package chap07;

public class Car {
	Tire fLt = new Tire(5,"앞왼쪽");
	Tire fRt = new Tire(2,"앞오른쪽");
	Tire bLt = new Tire(3,"뒤왼쪽");
	Tire bRt = new Tire(4,"뒤오른쪽");
	
	int run() {
		System.out.println("[자동차가 달립니다.]");
		if(fLt.roll()==false) { stop(); return 1; }
		if(fRt.roll()==false) { stop(); return 2; }
		if(bLt.roll()==false) { stop(); return 3; }
		if(bRt.roll()==false) { stop(); return 4; }
		return 0;
	}
	
	void stop() {
		System.out.println("자동차가 멈춥니다.");
	}

}
