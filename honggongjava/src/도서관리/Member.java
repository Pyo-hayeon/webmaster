package 도서관리;

import java.util.Date;

// 두단어 조합 할때 member_id (sql) / memberId (java)
public class Member {
	private String memberId;
	private String password;
	private String memberName;
	private String phone; 
	private String responsibility; 
	private Date creationDate;	//import java.util.Date;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Override
	public String toString() {
		return "ID : "+memberId +"\t비밀번호 : "+ password +"\t이름 : "+ memberName +"\t폰번호 : "+ phone +"\t권한 : "+ responsibility +"\t등록날짜"+ creationDate;	 
		//return super.toString();
	}
}
