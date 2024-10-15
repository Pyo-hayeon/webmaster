package chap07;

class Service{
	void login() {
		System.out.println("부모 로그인");
	}
}

class MemberService extends Service{
	@Override
	void login() {
		//super.login();
		System.out.println("멤버 로그인");
	}
}

class Aservice extends MemberService{
	@Override
	void login() {
		System.out.println("Aservice 로그인");
	}
}

public class Controller {
	public Service service;
	//public Service sv = new Service();
	public MemberService sv = new MemberService();
	
	void setService(Service service) {
		this.service = service;
	}
	
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		
		//메소드로 부모타입으로 자동변환
		controller.setService(new MemberService());
		controller.service.login();
		
		controller.setService(new Aservice());
		controller.service.login();
		
		//필드로 부모타입으로 자동변환
		controller.sv = new MemberService();
		controller.sv.login();
		
		controller.sv = new Aservice();
		controller.sv.login();
	}
}
