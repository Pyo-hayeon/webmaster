package com.yedam.control.reply;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ReplyListCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		//게시글 번호(bon)
		String bno = req.getParameter("bno");
		
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(Integer.parseInt(bno));
		//JSON 데이터 라이브러리로 간편하게 만들끼
		Gson gson = new GsonBuilder().create();	//Gson 쓰겠다는 말 객체 생성
		String json = gson.toJson(list);	//자바객체를 제이슨 문자열로 만들어주는 기능
		
		resp.getWriter().print(json);
		
		//이건 서블릿 형태
		//req.setAttribute("reply", reply);
		//req.getRequestDispatcher("").forward(req, resp);
	}

}
