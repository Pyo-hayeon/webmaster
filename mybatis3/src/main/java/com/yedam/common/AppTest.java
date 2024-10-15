package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

public class AppTest {
	public static void main(String[] args) {
		//MemberDAO dao = new MemberDAO();
		//마이바티스로 하기
		SqlSession sqlSession = DataSource.getInstance().openSession();
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		//등록
//		Member mbr = new Member();
//		mbr.setMemberid("test99");
//		mbr.setMemberName("연습99");
//		mbr.setPhone("010-9999-9999");
//		mbr.setPassword("999");
//		
//		if(dao.insertMember(mbr) == 1) {
//			sqlSession.commit();
//		}
		
		//업데이트
//		Member mbr1 = new Member();
//		mbr1.setMemberid("test99");
//		mbr1.setMemberName("연습99");
//		mbr1.setPhone("010-7777-7777");
//		mbr1.setPassword("7788");
//		if(dao.updateMember(mbr1) == 1) {
//			sqlSession.commit();
//		}
		
		//삭제
		Member mbr2 = new Member();
		mbr2.setMemberid("test99");
		if(dao.deleteMember(mbr2.getMemberid()) == 1) {
			sqlSession.commit();                                                                                                  
		}		
		
		List<Member> result = dao.members(); 
		for(Member member : result) {
			System.out.println(member.toString());
		}
	}
}
