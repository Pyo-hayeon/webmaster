package chap06;

public class MemberMain {

	public static void main(String[] args) {
		
		Member member2 = new Member("홍길동", "hong");
		System.out.printf("해당맴버의 이름:%s 나이:%d 아이디:%s 비밀번호:%s \n",member2.name,member2.age,member2.id,member2.password);
		System.out.println();
		
		Member member = new Member();
		member.name = "표하연";
		member.age = 35;
		member.id = "hayeon8521";
		member.password = "1234";
		
		member.memberinfo();
		
		System.out.println();
		
		Member member1 = new Member();
		member1.name = "김영희";
		member1.age = 20;
		member1.id = "younghee";
		member1.password = "4444";
		
		member1.memberinfo();
		
		
	}

}
