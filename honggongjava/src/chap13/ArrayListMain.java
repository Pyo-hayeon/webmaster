package chap13;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {

	public static void main(String[] args) {
		//리스트 컬렉션
		//ArrayList
		List<String> list = new ArrayList<String>();
		
		list.add("java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");
		
		int size = list.size();
		System.out.println("총 객체 수: "+size);
		System.out.println();
		
		String skill = list.get(2);
		System.out.println("2: "+skill);
		System.out.println();
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i+" : "+str);
		}
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");
		
		for(String str : list) {
			System.out.println(str);
		}
	
		//만약 100개까지 중복없이한다면
		//사이즈 확인해서 100개 이하이면 go // 이상이면 아웃
		//go로 와서 중복검사 하고 중복없으면 끝에 삽입
		//중복있으면 아웃
	}
}
