package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

//객체 생성하고 -> init() -> service() -> 서버가 종료되면 -> destroy() : 서블릿의 생명주기 

@WebServlet("/member.action")	//다음 서블릿 주소 연결
public class MemberControlServlet extends HttpServlet {	//제일먼저 HttpServlet 상속받기
	//생성자 생성
	public MemberControlServlet() {
		System.out.println("Membercontrol 객체 생성");
	}
	
	//최초 호출 메소드 ( 서블릿 init )
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("최초 요청이면 init 실행");
	}
	
	//그다음 실행 메소드 (요청할때마다 실행함)
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("서블릿을 요청할때마다 실행");
		
		//멤버 객체 받기
		SqlSession sqlSession = DataSource.getInstance().openSession(true);	//자동커밋
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		String id = req.getParameter("mid"); 
		
		// get : 조회화면 , post : 삭제처리.
		if(req.getMethod().equals("GET")) {
			//get값 받아서 처리하는 파라메터
			// http://localhost/mybatis3/member.action?mid=user01
			//member 여기안에 조회된 데이터가 다들어있을꺼임
			Member member = dao.selectMember(id);	//해당 메소드 호출해서 처리 처리한값을 객체에 다집어 넣었으니까
			if(member == null) {
				resp.getWriter().print("조회된 정보가 없습니다");
				return;
			}
			String str = "<h3>회원정보</h3>";
			str += "<form action='member.action' method='post'>";
			str += "<input type='hidden' name='mid' value='"+member.getMemberid()+"'>";
			str += "<table border='1'>";
			str += "<tr><th>회원아이디</ht><td>" + member.getMemberid() + "</td></tr>";
			str += "<tr><th>회원이름</ht><td>" + member.getMemberName() + "</td></tr>";
			str += "<tr><th>연락처</ht><td>" + member.getPhone() + "</td></tr>";
			str += "<tr><td colspan='2'><input type='submit' value='회원삭제'></td></tr>";
			str += "</table>";
			str += "</form>";
			str += "<a href='MemberListServlet'>목록으로</a>";
			resp.getWriter().print(str);
			
		}else if(req.getMethod().equals("POST")) {
			//post값 받아서 처리하는 파라메터
			//http://localhost/mybatis3/member.action
			if(dao.deleteMember(id) == 1) {
				resp.getWriter().print("<p>삭제완료</p>");
			}else {
				resp.getWriter().print("<p>삭제할 회원 없음.</p>");
			}
			resp.getWriter().print("<a href='MemberListServlet'>목록으로</a>");
		}
		
		
	}
	
	//서버가 종료될떄 실행
	@Override
	public void destroy() {
		System.out.println("서버가 종료될때 한번 실행");
	}
	
	
	
}
