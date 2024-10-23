package com.yedam.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	//길게 조회
	List<ReplyVO> replyList(int boardNo);
	//페이징 처리
	List<ReplyVO> selectListPaging(int boardNo, int page);
	//등록
	boolean registerReply(ReplyVO reply);
	//삭제
	boolean removeReply(int replyNo);
	//리플 단건 조회
	ReplyVO searchReply(int replyNo);
	//댓글 갯수 카운터
	int replyCount(int boardNo);
}
