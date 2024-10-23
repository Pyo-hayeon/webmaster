package com.yedam.control.reply;

import java.io.IOException;
import java.util.ArrayList;
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
		String page = req.getParameter("page");
		
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.selectListPaging(Integer.parseInt(bno), Integer.parseInt(page));
		//JSON 데이터 라이브러리로 간편하게 만들끼
		Gson gson = new GsonBuilder().create();	//Gson 쓰겠다는 말 객체 생성
		String json = gson.toJson(list);	//자바객체를 제이슨 문자열로 만들어주는 기능
		//{"replyNo":60,"reply":"댓글1","replyer":"user01","boardNo":265,"replyDate":"Oct 24, 2024, 12:05:34 AM"}
		resp.getWriter().print(json);
	}
}