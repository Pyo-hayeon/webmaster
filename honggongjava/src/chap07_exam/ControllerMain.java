package chap07_exam;

public class ControllerMain {

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		controller.setService(new MemberService());
		controller.service.login();
		
		controller.setService(new AService());
		controller.service.login();
		
		//controller.setService(new Service());
		controller.setService(new AService());
		controller.setService(new BService());
		//controller.setService(new BoardService());
		//controller.setService(new DService());
	}

}
