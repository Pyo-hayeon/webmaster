package chap07_exam;

class Service{
	public void login() {
		System.out.println("로그인");
	}
}

class MemberService extends Service{
	@Override
	public void login() {
		System.out.println("멤버 로그인");
	}
}
class BoardService extends Service{}

class AService extends MemberService{
	@Override
	public void login() {
		System.out.println("A 로그인");
	}
}
class BService extends MemberService{}

class DService extends BoardService{}

public class Controller {
	public MemberService service;
	
	public void setService(MemberService service) {
		this.service = service;
	}
}
