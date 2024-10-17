package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

// mysql (insertMember, updateMember)
// -> oracle (memberInsert, memberUpdate)
// 메소드 들이 바뀌면 재작업 하기 힘들어서 규칙을 정해놓고 그거 무조건 쓰게 만드는게
// 인터페이스 상속으로 오버라이드 해버리는거
public class MemberServiceImpl implements MemberService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public boolean addMember(MemberVO member) {
		return mapper.insertMember(member) == 1;
	}

	@Override
	public boolean retireMember(String memberId) {
		return mapper.deleteMember(memberId) == 1;
	}

	@Override
	public List<MemberVO> memberList() {
		return mapper.members();
	}

}
