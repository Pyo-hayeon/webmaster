package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

//화면 보여주는 컨트롤
public class MemberAddFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//jsp 페이지 open.
		req.getRequestDispatcher("WEB-INF/jsp/memberAddForm.jsp").forward(req, resp);
	}
	

}
