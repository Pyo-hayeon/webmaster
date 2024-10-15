package chap07;

public class HttpServletMain {

	public static void main(String[] args) {
		method(new LoginServlet());
		method(new FileDownloadServlet());
		//이거는 추상 클래스여서 객체 생성을 못함
		//method(new HttpServlet());
		
	}
	
	public static void method(HttpServlet servlet) {
		servlet.service();
	}

}
