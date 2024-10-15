package chap07;

public class PeopleSom extends People{
	//필드
	public int studentNo;
	
	//생성자
	public PeopleSom(String name, String ssn, int studentNo) {
		super(name, ssn);
		this.studentNo = studentNo;
	}
	//메소드
	
}
