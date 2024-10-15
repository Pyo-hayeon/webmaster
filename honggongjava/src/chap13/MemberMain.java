package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MemberMain {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 25));
		set.add(new Member("최길동", 25));
		set.add(new Member("최길동", 30));
		
		System.out.println("총 객체 수 : "+set.size());
		
		//이더레이터의 객체 에 대입한다 = Member클래스의 set객체의 데이터를 한번씩 리턴한다 
		Iterator<Member> iterator = set.iterator();
		//리턴딘 값이 hasNext() 값이 없으면 false를 리턴한다
		while(iterator.hasNext()) {
			//컬랙션에서 하나의 객체를 가져와서 멤버객체에 넣는다 String이면 String 변수에 넣는다
			Member element = iterator.next();
			System.out.println("멤버 클래스 객체 해시코드 : "+element.hashCode());
			System.out.println("재정의된 해시코드 : "+element.name.hashCode() + element.age);
			System.out.println(element.name+"\t"+element.age+"\n");
		}
		//Member 클래스에 해시코드 오버라이딩 된 내용 주석 풀어야함
		
		System.out.println();
		
		for(Member ele : set) {
			System.out.println(ele.name+"\t"+ele.age+"");
		}
		
		/*재정의 하는 이유는 동일 객체에서는 데이터가 동일한지 아닌지 확인 해야할때
		 * set은 그냥 뭉뚱그려서 한덩이라서 딱 집어서 원하는걸 못데려와서 그런다
		 * 근데 재정의된 메소드는 어떻게 불러오냐?? 불러올 필요가 없다 set 실행될때
		 * set안에 메소드 호출이 들어있다.  set.add(); */
	}

}
