package chap07;

public class CellPhoneMain {

	public static void main(String[] args) {
		
		//자식 클래스로 db 객체를 만듬
		//db객체 필드는 채널 뿐이지만 부모한테서 이름과 색상을 상속받음
		DmbCellPhone dc = new DmbCellPhone("자바폰", "핑크", 10);
		
		//상속 받은 필드
		System.out.println(dc.model);
		System.out.println(dc.color);
		//원래 자기 필드
		System.out.println(dc.channel);
		
		//상속 받은 메소드
		dc.powerOff();
		dc.powerOn();
		dc.bell();
		dc.sendVoice("s");
		dc.receiveVoice("bb");
		dc.hangup();
		
		//원래 자기 메소드
		dc.turnOffDmb();
		dc.turnOnDmb();
		dc.changChannelDmb(11);

	}

}
