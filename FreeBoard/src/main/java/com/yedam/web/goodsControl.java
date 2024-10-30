package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.GoodsService;
import com.yedam.service.GoodsServiceImpl;

public class goodsControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String goodsno = req.getParameter("goodsno");
		
		GoodsService svc = new GoodsServiceImpl();
		
		if(svc.deleteGoods(Integer.parseInt(goodsno))) {
			//참인경우 처리
		}else {
			//거짓인경우 실패한경우 처리
		}
		
		//요기페이지에 보여줘야한다
		resp.getWriter().print("adfasdfasd");
		
		//다른페이지에 넘겨줘야한다
		req.setAttribute(goodsno, "result");
		req.getRequestDispatcher("").forward(req, resp);
		
	}
}
