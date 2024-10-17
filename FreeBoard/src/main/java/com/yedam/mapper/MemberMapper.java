package com.yedam.mapper;

import java.lang.reflect.Member;
import java.util.List;

import com.yedam.vo.MemberVO;

//인터페이스 기능정의
//구현클래스 기능실행
public interface MemberMapper {
	public List<MemberVO> members();
	public int insertMember(MemberVO member);
	public int updateMember(MemberVO member);
	public int deleteMember(String memberId);
	public Member selectMember(String member_id);	//단건조회 기능추가
}
