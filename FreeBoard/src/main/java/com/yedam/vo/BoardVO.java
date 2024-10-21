package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data	//이거하나쓰면 게터 세터 투스트링 다 만들어짐 지금 보이느거 다 오버라이딩 된거임 ㄷㄷ
public class BoardVO {
	private int boardNo; // board_no - boardNo
	private String title;
	private String content;
	private String writer;
	private String writerName;	//언더바 표기로 자동 변경됨
	private int viewCnt;	//언더바 표기로 자동 변경됨
	private Date writeDate;	//언더바 표기로 자동 변경됨
	private Date updateDate;	//언더바 표기로 자동 변경됨
	private String img;	//이미지 저장 객체
	
}
