package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	
	private String memberId;
	private String password;
	private String memberName;
	private String phone;
	private String responsibility;
	private Date creationDate;
	
	private String title;
	private String startDate;
	private String endDate;
}
