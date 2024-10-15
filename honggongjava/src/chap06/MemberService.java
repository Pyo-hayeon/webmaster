package chap06;

public class MemberService {
	//필드
	//생성자
	
	//객체
	void logout(String id) {
		System.out.println(id+"님이 로그아웃 되었습니다");
		return;
	}
	
	boolean login(String id, String pw) {
		if(!id.equals("hong") || !pw.equals("12345")) {
			return false;
		}else {
			return true;
		}
	}
}
