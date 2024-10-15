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

@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>회원 목록</h1>");
		SqlSession sqlSession = DataSource.getInstance().openSession(true);	//자동커밋
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		List<Member> result = dao.members(); 
		out.print("<ul>");
		for(Member mb : result) {
			out.print("<li>");
			out.print("ID : "+mb.getMemberid());
			out.print(" | PW : "+mb.getPassword());
			out.print(" | 이름 : "+mb.getMemberName());
			out.print(" | 연락처 : "+mb.getPhone());
			out.print(" | 권한 : "+mb.getResponsibility());
			out.print(" | 가입일 : "+mb.getCreationDate());
			out.print("</li>");
		}
		out.print("</ul>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
