package 도서관리;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//목록(조회조건), 등록, 수정, 삭제, 단건.
public class MemberDao extends DAO{
	//Connection, getCon, getClose
	
	//싱글톤 방식 아래꺼 있으면 메인에 싱글톤 객체 만들어야하고
	//이렇게하면 메모리 절약할수있다고함
	private static MemberDao instance = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {
		return instance;
	}
	
	
	// 목록조회/ [메소드 임]
	List<Member> memberList() {
		String sql = ""
					+"select member_id "
					+"		,member_name"
					+"		,password"
					+"		,phone"
					+"		,responsibility"
					+"		,creation_date"
					+"	from tbl_member ";
		
		List<Member> result = new ArrayList<>();
		
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();	//조회 (데이터에 변경이없는거는 executeQuery)
			while(rs.next()) {
				//객체 만들고
				Member member = new Member();
				//해당 객체에 데이터 집어 넣고
				member.setMemberId(rs.getString("member_id"));
				member.setPassword(rs.getString("password"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				member.setCreationDate(rs.getDate("creation_date"));
				
				//데이터 들어간 객체를 List객체에 넣어줌
				result.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}//memberList()
	
	//로그인
//	public String checkMember(String id, String pw) {
		// 값이 이으면 1 // 값이 없으면 null  // count(1)
//		String sql = "select count(1) from tbl_member"
//				+ "		where member_id = ? and password = ?"; 
//		String sql = ""
//				+"	select member_name "
//				+" from tbl_member "
//				+" where member_id=? "
//				+ " and password = ? ";
//		getOpen();
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, id);
//			psmt.setString(2, pw);
//			rs = psmt.executeQuery();
//			if(rs.next()) {
//				//System.out.println(rs.getString("member_name")+"님 환영합니다");
//				return rs.getString("member_name");
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "fail";
//	}
	
	//로그인 여러가지 값을 담기위해서 맴버로 메소드 만듬
	Member checkMember(String id, String pw) {
		String sql = ""
				+"	select member_name, responsibility  "
				+" from tbl_member "
				+" where member_id=? "
				+ " and password = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Member member = new Member();
				member.setMemberName(rs.getString("member_name"));
				member.setResponsibility(rs.getString("responsibility"));
				return member;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Member suchmember(String memberId){
		
		String sql = ""
					+"select * "
					+"	from tbl_member "
					+"	where member_id =? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberId);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setPassword(rs.getString("password"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				member.setCreationDate(rs.getDate("creation_date"));
				return member;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	public void insertmember(Member mb) {
		String sql = ""
				+"insert into "
				+"	tbl_member (member_id, password, member_name, phone, responsibility, creation_date) "
				+"	values(?, ?, ?, ?, ?, sysdate)";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mb.getMemberId());
			psmt.setString(2, mb.getPassword());
			psmt.setString(3, mb.getMemberName());
			psmt.setString(4, mb.getPhone());
			psmt.setString(5, mb.getResponsibility());
			int rows =  psmt.executeUpdate();
			if(rows==1) {
				System.out.println("멤버 등록 완료");
			}else {
				System.out.println("멤버 등록 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public boolean deletemember(String member_id) {
		String sql = ""
				+"delete from tbl_member  "
				+"	where member_id=? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member_id);
			int rows =  psmt.executeUpdate();
			if(rows==1) {
				return true;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	public boolean updatemember(Member mb) {
		String sql = "update tbl_member "
				+ " set ";
	if(!mb.getPassword().equals("0")) {
		sql += "password = '"+mb.getPassword()+"'";
	}
	
	if(mb.getMemberName().equals("0") && mb.getPhone().equals("0") && mb.getResponsibility().equals("0")) {
	}else {
		sql += ", ";
	}
	
	if(!mb.getMemberName().equals("0")) {
		sql += "member_name = '"+mb.getMemberName()+"'";
	}
	
	if(mb.getPhone().equals("0") && mb.getResponsibility().equals("0")) {
	}else {
		sql += ", ";
	}
	
	if(!mb.getPhone().equals("0")) {
		sql += "phone = '"+mb.getPhone()+"'";
	}
	
	if(mb.getResponsibility().equals("0")) {
	}else {
		sql += ", ";
	}
	
	if(!mb.getResponsibility().equals("0")) {
		sql += "responsibility = '"+mb.getResponsibility()+"'";
	}
	
	sql += "	where member_id=? ";
		//System.out.println(sql);
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mb.getMemberId());
			int rows =  psmt.executeUpdate();
			if(rows==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}//class MemberDao
