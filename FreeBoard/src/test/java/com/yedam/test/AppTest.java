package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.ReplyMapper;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.BoardVO;
import com.yedam.vo.ReplyVO;

//기능들 정상적으로 됐는지 확인하는 페이지 [테스트 페이지]
public class AppTest {
	public static void main(String[] args) {
		//sql 실행 명령문
		//SqlSession sqlSession = DataSource.getInstance().openSession(true);
		ReplyService svc = new ReplyServiceImpl();
		
		ReplyVO rv1 = new ReplyVO();
		rv1.setBoardNo(361);
		rv1.setReply("aaa");
		rv1.setReplyer("user01");
		svc.registerReply(rv1);
		
		
		List<ReplyVO> list =  svc.replyList(361);
		for(ReplyVO rv : list) {
			System.out.println(rv.toString());
		}
		
		svc.removeReply(42);
		
		svc.replyList(361).forEach(reply -> System.out.println(reply));
		
		//인서트 테스트
//		BoardVO bvo = new BoardVO();
//		bvo.setTitle("mapperTest");
//		bvo.setContent("my name is content Test");
//		bvo.setWriter("user01");
//		if(mapper.insertBoard(bvo)==1) {
//			//sqlSession.commit();
//			System.out.println("정상 작동 됩니다");
//		}
		
		//업데이트 테스트
//		BoardVO bvo = new BoardVO();
//		//bvo.setTitle("mapperTest");
//		bvo.setContent("이거슨 내용 변경 테스트입니다");
//		bvo.setWriter("user01");
//		bvo.setBoardNo(21);
//		if(mapper.updateBoard(bvo)==1) {
//			//sqlSession.commit();
//			System.out.println("정상 작동 됩니다");
//		}
		
		//삭제 테스트
//		BoardVO bvo = new BoardVO();
//		//bvo.setTitle("mapperTest");
//		bvo.setBoardNo(21);
//		if(mapper.deleteBoard(bvo.getBoardNo())==1) {
//			//sqlSession.commit();
//			System.out.println("삭제완료");
//		}
		
		
		//선택 데이터 조회
//		if(mapper.selectBoard(4)==null) {
//			System.out.println("조회된 데이터가 없습니다");
//		}else {
//			BoardVO bvo = mapper.selectBoard(4);
//			System.out.println(bvo.toString());
//			System.out.println();
//		}
		
		//리스팅 테스트
//		List<BoardVO> list = mapper.boardList();
//		for(BoardVO bvo2 : list) {
//			System.out.println(bvo2.toString());
//		}
		
		//검색 조건 가져오기
		//SearchDTO search = new SearchDTO();
		//search.setKeyword("user01");
		//search.setSearchCondition("W");
		//search.setPage(1);
		
		//페이징 테스트
//		List<BoardVO> list = mapper.listWithPage(search);
//		for(BoardVO bvo2 : list) {
//			System.out.println(bvo2.toString());
//		}
		
	}//main
}//AppTest
