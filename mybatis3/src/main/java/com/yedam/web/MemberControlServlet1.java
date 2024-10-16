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

@WebServlet("/member1.action")
public class MemberControlServlet1 extends HttpServlet{
	
	//생성자
	public MemberControlServlet1() {
		System.out.println("MemberControlServlet1 객체 생성");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("MemberControlServlet1 최초요청 init()");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//멤버 객체 받기
		SqlSession sqlSession = DataSource.getInstance().openSession(true);	//자동커밋
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		//URL get 방식으로 가져온거 받는 함수 
		String id = req.getParameter("mid");	//http://localhost/mybatis3/member.action?mid=user01
		
		//get으로 데이터를 가지고 들어오면 회원정보 조회가 되고
		//해당회원 정보에서 삭제버튼 누르면 다시 동일페이지 접속하되 post 데이터 받아와서 회원삭제 처리함
		//get인지 post인지 구별하기
		if(req.getMethod().equals("GET")) {
			
			//sql 메소드 호출해서 리턴 받은 객체내용 저장
			Member member = dao.selectMember(id);
			
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
			//http://localhost/mybatis3/member.action
			//deleteMember메소드는 membermapper.xml 에 구현해놨음
			if(dao.deleteMember(id) == 1) {
				resp.getWriter().print("<p>삭제완료</p>");
			}else {
				resp.getWriter().print("<p>삭제할 회원 없음.</p>");
			}
			resp.getWriter().print("<a href='MemberListServlet'>목록으로</a>");
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("MemberControlServlet1 서버가 종료될때 한번 실행");
	}

}
