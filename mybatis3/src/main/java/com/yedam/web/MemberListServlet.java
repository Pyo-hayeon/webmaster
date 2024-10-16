package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

//@WebServlet("/MemberListServlet")이게 제일 중요함 여기로 요청 들어오면 기능이 실행된다
//이게 경로임 html/MemberListServlet 이라고 적으면 위치가 저기로 바뀜

//IOC (제어의 역전) 이라고 함
//반드시 HttpServlet 기능을 상속받아야함
//객체 생성하고 -> inti() -> service() -> 서버가 종료되면 -> destroy() : 서블릿의 생명주기 
//를 순서대로 실행 톰캣이 자체적으로
@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String str = "<h3>회원정보</h3>";
		str +="<table border='1'><tbody>";
		str +="<thead><tr><th>회원아이디</th><th>회원명</th><th>연락처</th></tr></thead>";
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true);	//자동커밋
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		List<Member> result = dao.members(); 
		for(Member mb : result) {
			str += "<tr><td><a href='member.action?mid="+mb.getMemberid()+"'>"+mb.getMemberid();
			str += "</a></td><td>"+mb.getMemberName();
			str += "</td><td>"+mb.getPhone() + "</td></tr>";
		}
		str += "</tbody></table>";
		str += "<h3><a href='./'>처음으로<a></h3>";
		response.getWriter().print(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
