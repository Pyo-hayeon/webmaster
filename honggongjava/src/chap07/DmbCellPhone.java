package chap07;

//CellPhone 클래스를 상속받음
public class DmbCellPhone extends CellPhone{
	//필드
	int channel;
	
	//생성자
	DmbCellPhone(String model, String color, int channel){
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	//메소드
	void turnOnDmb() {
		System.out.println("채널 "+channel+"번 DMB 방송 수신");
	}
	void changChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널 "+channel+"번으로 바꿈");
	}
	void turnOffDmb() {
		System.out.println("DMB 수신 종료");
	}

}
