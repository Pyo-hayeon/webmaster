package chap07;

public class PeopleMain {
	public static void main(String[] args) {
		PeopleSom ps = new PeopleSom("홍길동","894564-1234567", 1234);
		
		//부모에게 상속받은 생성자
		System.out.println(ps.name);
		System.out.println(ps.ssn);
		
		//원래 자기 생성자
		System.out.println(ps.studentNo);
	}
}
