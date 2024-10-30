package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.GoodsMapper;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

// mysql (insertMember, updateMember)
// -> oracle (memberInsert, memberUpdate)
// 메소드 들이 바뀌면 재작업 하기 힘들어서 규칙을 정해놓고 그거 무조건 쓰게 만드는게
// 인터페이스 상속으로 오버라이드 해버리는거
public class GoodsServiceImpl implements GoodsService  {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
	
	
	@Override
	public boolean deleteGoods(int goodsNo) {
		return mapper.deleteGoods(goodsNo) == 1;
	}

}
