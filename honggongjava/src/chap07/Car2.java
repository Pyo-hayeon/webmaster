package chap07;

public class Car2 extends Car2Som{
	
	//상속 받아서 오버라이딩 가능
	@Override
	public void speedUp() {
		speed += 10;
	}
	
	//final로 인하여 오버라이딩 불가능
//	@Override
//	public void stop() {
//		System.out.println("스포츠카 멈춤");
//		speed = 0;
//	}
}
