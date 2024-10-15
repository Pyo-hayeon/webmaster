package chap08;

public class Audio implements RemoteControl{
	//필드
	private int volume;
	//생성자
	
	//메소드 (인터페이스에서 정의한 메소드 다 재정의 해줘야함!!)
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다");
	}
	@Override
	public void turnOff() {
		System.out.println("Audio를 끔니다");		
	}
	
	//RemoteControl.MAX_VOLUME 상수 당겨오는법!!! <-상수 관련 페이지에서 다시 공부해
	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 Audio 볼륨은 "+this.volume);
	}
}
