package test13;

public class ArrayListMain {

	public static void main(String[] args) {
		
		//컨트롤 클래스 객체 생성
		ArrayListControl alc = new ArrayListControl();
		//컨트롤 클래스의 메소드 이용해서 리스트 객체  생성
		alc.setArrat("abc");
		alc.setArrat("ab1c");
		alc.setArrat("abc2");
		
		//리스트 기본메소드 이용해서 객체 생성
		alc.list.add("abcd");
		alc.list.add(3,"abc");
		
		//리스트 기본 메소드 이용해서 객체 삭제
		alc.list.remove("abc");
		
		System.out.println();
		System.out.println(alc.list.get(3));
		System.out.println(alc.list.size());
		System.out.println();
		//기본 for문으로 객체 호출
		for(int i=0; i<alc.list.size(); i++) {
			System.out.println(alc.list.get(i));
		}
		System.out.println();
		//항상된 for문으로 객체 호출
		for(String str : alc.list) {
			System.out.println(str);
		}
		
		//리스트 객체 전체 삭제
		alc.list.clear();
		
		System.out.println(alc.list);
	}

}
