package chap07;

public class HankookTire extends Tire{
	//필드
	//생성자
	HankookTire(int maxRotation, String location){
		super(maxRotation, location);
	}
	//메소드
	@Override
	public boolean roll() {
		accRotation++;
		if(accRotation < maxRotation) {
			System.out.println(location + "한국 Tire 수명" + (maxRotation-accRotation) + "회 남음");
			return true;
		}else {
			System.out.println("***"+location+"한국 Tire 펑크***");
			return false;
		}
	}

}
