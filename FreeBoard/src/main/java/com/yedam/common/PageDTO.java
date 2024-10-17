package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	private int startPage, endPage;
	private boolean prev, next;
	private int page; //현재페이지
	
	public PageDTO(int page) {
		int totalCnt = 128;
		//페이지 번호 메기는거 < 1 2 3 4 5 6 7 8 9 10 > 이렇게 나오게 하려고
		this.endPage = (int)Math.ceil(page / 10.0) * 10; 
		this.startPage = this.endPage - 9;
		
		int realEnd = (int) Math.ceil(totalCnt / 5.0);
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
