package test13;

import java.util.Iterator;

public class MemberSetMain {

	public static void main(String[] args) {

		MemberSetControl msc = new MemberSetControl();
		
		msc.setadd("홍길동",30);
		msc.setadd("표하연",30);
		msc.setadd("박땡땡",20);
		msc.setadd("배땡땡",25);
		msc.setadd("권땡땡",24);
		msc.setadd("김땡땡",23);
		
		Iterator<MemberSet> iterator = msc.set.iterator();
		while(iterator.hasNext()) {
			MemberSet ms = iterator.next();
			System.out.println("이름:"+ms.name+" 나이:"+ms.age);
		}
		
		System.out.println();
		msc.set.remove(new MemberSet("홍길동", 30));
		
		//삭제 또는 추가가 일어나면 ★항상 반복자 초기화 필요
		iterator = msc.set.iterator();
		while(iterator.hasNext()) {
			MemberSet ms = iterator.next();
			if(ms.name.equals("홍길동")) {
				System.out.println(ms);
			}else {
				System.out.println("이름:"+ms.name+" 나이:"+ms.age);
			}
		}
		
		System.out.println();
		
		//항상된 for문으로하면 반복자 초기화 없어도 가능
		for(MemberSet ele : msc.set) {
			System.out.println(ele.name);
		}
		
		
		System.out.println("총객체수 : "+msc.set.size());

	}

	

}
