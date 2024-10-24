package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.MemberVO;

//업무처리로직
public interface MemberService {
	boolean addMember(MemberVO member);
	boolean retireMember(String memberId);
	
	//회원목록출력메소드
	List<MemberVO> memberList();
	
	//로그인
	MemberVO loginCheck(String id, String pw);
	
	//캘린더
	List<Map<String, Object>> countBySelectable();
	boolean addSelectable(MemberVO member);
	boolean deleteSelectable(MemberVO member);
}
