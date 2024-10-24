package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class InsertSelectablecont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//title='+title+'&start='+arg.start+'&end='+arg.end)
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");

		MemberService svc = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		member.setTitle(title);
		member.setStartDate(start);
		member.setEndDate(end);
		
		//System.out.println(member.toString());

		//반환값을 선언.
		Map<String, Object> result = new HashMap<>();
		
		//성공했을때
		if(svc.addSelectable(member)) {
			// 반환해야하는 값 : {retCode:OK, retVal: rvo}
			result.put("retCode", "OK");
		}else {
			result.put("retCode", "FAIL");
		}

		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(result));

	}
}