package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

//등록처리 컨트롤
public class MemberAddControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("MemberAddControl");
		//mid=user11&mname=테에스트&passwd=1234&phone=231
		String id = req.getParameter("mid");
		String nm = req.getParameter("mname");
		String pw = req.getParameter("passwd");
		String pn = req.getParameter("phone");
		
		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id);
		mvo.setMemberName(nm);
		mvo.setPassword(pw);
		mvo.setPhone(pn);
		
		MemberService svc = new MemberServiceImpl();
//		if(svc.addMember(mvo)) {
//			//목록 페이지로 이동.
//			resp.sendRedirect("memberList.do");
//		}else {
//			//등록화면으로 이동.
//			resp.sendRedirect("memberAddForm.do");
//		}
		
		//이렇게도 가능함 동일함
		try {
			svc.addMember(mvo);
			//목록 페이지로 이동.
			resp.sendRedirect("memberList.do");
		}catch(Exception e) {
			//등록화면으로 이동.
			e.printStackTrace();
			resp.sendRedirect("memberAddForm.do");
		}
	}


}
