package chap06;

public class Member {
	//객체
	String name;
	String id;
	String password;
	int age;
	
	//생성자
	Member(){}
	
	Member(String name, String id){
		this.name = name;
		this.id = id;
	}
	//메소드
	void memberinfo() {
		System.out.printf("해당맴버의 이름:%s 나이:%d 아이디:%s 비밀번호:%s \n",name,age,id,password);
	}

}
