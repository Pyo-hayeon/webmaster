package com.yedam.control.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class memberJsonCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//회원 목록을 json형태로 반환해줄려고함
		//sql에서 데이터 가져와서 json형태로 만들면됨
		
		//응답 데이터가 한글깨지지 않게 변경
		resp.setContentType("application/json;charset=utf-8");
		
		//회원 목록을 불러와서 List에 저장
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList();
		
		// [{"memberId": "user01", "memberName":"사용자1", "phone":"123-123-123"},
		//  {"memberId": "user01", "memberName":"사용자1", "phone":"123-123-123"},
		//  {"memberId": "user01", "memberName":"사용자1", "phone":"123-123-123"}]
		//형태로 만들기
		
		String json = "[";
		for(int i=0; i<list.size(); i++) {
			json += " {\"memberId\":\""+list.get(i).getMemberId()+"\"";
			json += ",\"memberName\":\""+list.get(i).getMemberName()+"\"";
			json += ",\"phone\":\""+list.get(i).getPhone()+"\"";
			json += "}";
			//제일 마지막 실행회차에는 뒤에 ,를 안넣는다
			if(i != list.size()-1) {
				json += ",";
			}
		}
		json += "]";
		
		//응답데이터에 만들어진 Json 값을 넣는다
		resp.getWriter().print(json);
	}
}
