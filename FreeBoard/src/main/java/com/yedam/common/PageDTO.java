package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	private int startPage, endPage;
	private boolean prev, next;
	private int page; //현재페이지
	
	public PageDTO(int page, int totalCnt) {
		//int totalCnt = 64;	//64이면 최종 페이지가 13페이지가 마지막 임
		//13페이지 까지 만들고 뒷페이지는 안보겠다는거
		
		//이제 토탈 카운터 가져오니까 정상 페이징 기능으로 작동함
		
		this.page = page;
		this.endPage = (int)Math.ceil(page / 10.0) * 10; 
		this.startPage = this.endPage - 9;
		
		//realEnd이게 진짜 마지막페이지
		int realEnd = (int) Math.ceil(totalCnt / 5.0);	//건수 기준으로 계산 해서 최종페이지를 가져옴
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
