package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

//뭐가 들어와도 상관없고 끝값이 .do 로 끝나면 해당 클래스를 실행하겠따는 의미
@WebServlet("*.do")
public class FrontController extends HttpServlet{
	//필드
	//url객체 담고 뒤에는 컨트럴 객체 담을꺼임
	Map<String, Control> map;
	//생성자
	public FrontController() {
		//System.out.println("객체생성");
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//System.out.println("init호출");
		map.put("/memberList.do", new MemberListControl());
		map.put("/memberAdd.do", new MemberAddControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("service호출");
		//요청 페이지가 먼지 알면 여기서 처리를 할수있따
		String uri = req.getRequestURI();	//요청페이지 URL을 읽어준다	/FreeBoard/add.do (프로젝트이름과 요청하는 마지막 페이지를 가져온다)
		String context = req.getContextPath();	//요청페이지의 프로젝트명 /FreeBoard
		String page = uri.substring(context.length());	//프로젝트명 자른 나머지	/add.do
		
		Control control = map.get(page);
		control.exec(req, resp);
		
	}
	
	
	
}