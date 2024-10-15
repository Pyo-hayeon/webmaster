package chap07;

public class CellPhone {
	//필드
	String model;
	String color;
	
	//생성자
	//메소드
	void powerOn() {
		System.out.println("power ON");
	}
	void powerOff() {
		System.out.println("power OFF");
	}
	void bell() {
		System.out.println("전화 왔쑝");
	}
	void sendVoice(String message) {
		System.out.println("자기 메세지 : "+message);
	}
	void receiveVoice(String message) {
		System.out.println("상대방 메세지 : "+message);
	}
	void hangup() {
		System.out.println("전화끈음");
	}

}
