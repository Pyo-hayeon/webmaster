package com.yedam.mapper;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

//인터페이스 기능정의
//구현클래스 기능실행
public interface GoodsMapper {
	
	int deleteGoods(int goodsNo);
}