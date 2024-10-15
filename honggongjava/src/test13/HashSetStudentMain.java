package test13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetStudentMain {

	public static void main(String[] args) {
		
		Set<HashSetStudent> set = new HashSet<HashSetStudent>();
		
		if(set.add(new HashSetStudent(20280202,"표하연"))){
			System.out.println("값 저장에 성공하였습니다");
		}else {
			System.out.println("값 저장에 실패하였습니다");
		}
		if(set.add(new HashSetStudent(20280202,"표하연"))){
			System.out.println("값 저장에 성공하였습니다");
		}else {
			System.out.println("값 저장에 실패하였습니다");
		}
		if(set.add(new HashSetStudent(20280203,"표하연"))){
			System.out.println("값 저장에 성공하였습니다");
		}else {
			System.out.println("값 저장에 실패하였습니다");
		}
		if(set.add(new HashSetStudent(20280203,"최하연"))){
			System.out.println("값 저장에 성공하였습니다");
		}else {
			System.out.println("값 저장에 실패하였습니다");
		}
		
		System.out.println();
		
		for(HashSetStudent str : set) {
			System.out.println(str.sNo+" "+str.name);
		}
		
		System.out.println();
		
		Iterator<HashSetStudent> iterator = set.iterator();
		while(iterator.hasNext()) {
			HashSetStudent hst = iterator.next();
			System.out.println(hst.sNo + " " + hst.name);
		}

	}

}
