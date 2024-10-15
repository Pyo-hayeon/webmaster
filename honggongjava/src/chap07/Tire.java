package chap07;

public class Tire {
	//필드
	public int maxRotation;	//최대 회전수
	public int accRotation;	//0부터 계속 돌아가는거
	public String location;	//바퀴 위치
	//생성자
	Tire(int maxRotation, String location){
		this.maxRotation = maxRotation;
		this.location = location;
	}
	//메소드
	public boolean roll() {
		accRotation++;
		if(accRotation < maxRotation) {
			System.out.println(location + "Tire 수명" + (maxRotation-accRotation) + "회 남음");
			return true;
		}else {
			System.out.println("***"+location+"Tire 펑크***");
			return false;
		}
	}

}
