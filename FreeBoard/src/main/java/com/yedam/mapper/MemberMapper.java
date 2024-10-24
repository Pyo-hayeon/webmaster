package com.yedam.mapper;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

//인터페이스 기능정의
//구현클래스 기능실행
public interface MemberMapper {
	public List<MemberVO> members();
	public int insertMember(MemberVO member);
	public int updateMember(MemberVO member);
	public int deleteMember(String memberId);
	public Member selectMember(String member_id);	//단건조회 기능추가
	//아이디 & 비밀번호
	//어노테이션으로 param을 사용함으로써 맵퍼xml에서 데이터 받을때 순서 상관없이 매핑되어 받을수 있게함!!
	public MemberVO loginMember(@Param("id") String id, @Param("pw") String pw);
	
	// 달력 내용 가져오기 게시글 작성 건수
	List<Map<String, Object>> countBySelectable();
	// 달력 내용 삽입하기
	public int insertSelectable(MemberVO member);
	// 달력 내용 삭제하기
	public int deleteSelectable(MemberVO member);
}
