package chap06;

public class Student {
	//필드 - 속성을 가지는거(객체만의 유니크키)
	String stNo;	//학생번호
	String name;	//학생이름
	
	//생성자(객체 생성 - 메소드가 동작되도록 하는거)
	//생성자는 객체클래스 이름과 동일하게 함
	//객체의 속성을 초기화
	//생성자는 리턴값이없음
	Student(String stNo, String name){
		//필드와 매게변수 값이 같지 않아서
		//누가 누군지 모를때 this를 사용함!!!
		this.stNo = stNo;
		this.name = name;
	}

	//메소드 - 동작을 가지는거
	void study() {
		System.out.println(name+"는 공부합니다");
	}
}
