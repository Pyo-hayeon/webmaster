package chap06;

public class MemberServiceMain {

	public static void main(String[] args) {
		MemberService myMember = new MemberService();
		
		String id = "hong";
		String pw = "12345";
		
		if(myMember.login(id, pw)) {
			System.out.println(id+"님이 로그인 되었습니다.");
			myMember.logout(id);
		}else {
			System.out.println("아이디 또는 비번 오류");
		}
		
		
		
	}
}
