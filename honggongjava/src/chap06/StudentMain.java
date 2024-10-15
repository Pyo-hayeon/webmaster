package chap06;

public class StudentMain {

	public static void main(String[] args) {
		//클래스도 객체 생성하면서 자동으로 만들게 하면됨
		//객체 생성할때 생성자 안만들면 x 표시 뜨는데 눌러서 반자동으로 만들수 있음
		
		//객체 생성 및 초기화
		Student st1 = new Student("20240901", "표하연");
		
		//객체 속성 호출
		System.out.println(st1.stNo);
		System.out.println(st1.name);
		
		//객체 메소드 호출
		st1.study();
		
		Student st2 = new Student("20240927", "김영희");
		System.out.println(st2.stNo);
		System.out.println(st2.name);
		st2.study();
	}

}
