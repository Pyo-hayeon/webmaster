package test13;

import java.util.HashSet;
import java.util.Set;

public class MemberSetControl {
	
	//Set 컬렉션 객체 생성
	Set<MemberSet> set = new HashSet<MemberSet>();

	
	public void setadd(String str, int i) {
		//Set컬렉션에 객체 삽입
		set.add(new MemberSet(str, i));
	}
}
