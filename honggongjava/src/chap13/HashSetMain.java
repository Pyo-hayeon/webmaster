package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetMain {

	public static void main(String[] args) {
		//set : 순서 보장 안됨, 중복 객체 저장 안됨, 반복자 필요함
		Set<String> set = new HashSet<String>();
		
		set.add("java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("java");
		set.add("iBATIS");
		
		int size = set.size();
		System.out.println("총 객체 수: "+size);
		
		System.out.println();
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		
		System.out.println();
		
		set.remove("JDBC");
		set.remove("iBATIS");
		
		//iterator = set.iterator();
		
		//항상된 포문은 조건 시작전에 이미 크기가 정해져있어서, 삭제하거나 추가를 못함
		for(String element : set) {
			System.out.println("\t"+element);
		}
		
		System.out.println();
		
		set.clear();
		if(set.isEmpty()) {
			System.out.println("비어있음");
		}

	}

}
