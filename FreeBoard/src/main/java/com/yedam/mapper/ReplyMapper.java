package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	//댓글 리스트
	List<ReplyVO> selectList(int boardNo);
	//댓글 페이징 리스트
	List<ReplyVO> selectListPaging(@Param("bno") int boardNo, @Param("page") int page);
	//삭제
	int deleteReply(int replyNo);
	//등록
	int insertReply(ReplyVO reply);
	//단건조회
	ReplyVO selectReply(int replyNo);
	//댓글 건수
	int selectCount(int boardNo);
}
