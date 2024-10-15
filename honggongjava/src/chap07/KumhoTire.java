package chap07;

public class KumhoTire extends Tire{
	//필드
	String maker = "금호";
	//생성자
	KumhoTire(int maxRotation, String location){
		super(maxRotation, location);
	}
	//메소드
	@Override
	public boolean roll() {
		accRotation++;
		if(accRotation < maxRotation) {
			System.out.println(location + "금호 Tire 수명" + (maxRotation-accRotation) + "회 남음");
			return true;
		}else {
			System.out.println("***"+location+"금호 Tire 펑크***");
			return false;
		}
	}

}
