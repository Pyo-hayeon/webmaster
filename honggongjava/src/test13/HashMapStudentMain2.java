package test13;

import java.util.HashMap;
import java.util.Map;

public class HashMapStudentMain2 {

	public static void main(String[] args) {
		
		//객체를 키로 넣는 방법
		Map<HashMapStudent, Integer> map = new HashMap<HashMapStudent, Integer>();
		
		
		//성공시 null 리턴
		System.out.println(map.put(new HashMapStudent(1,"홍길동",100), 23));
		map.put(new HashMapStudent(2,"성춘향",100), 30);
		
		System.out.println();
		
		//키에 있는 객체 꺼내는 방법
		//for 말곤 도저히 생각 못해내겠음 ㅠㅠ
		//for문안에 조건 하지말고 플레그 세워서 밖에다 유뮤 판단해서 추가하거나 해야함
		for (Map.Entry<HashMapStudent, Integer> entry : map.entrySet()) {
			HashMapStudent hms = entry.getKey();
			if(hms.sno == 1) {
		    	System.out.printf("학번:%d 이름:%s 점수:%d 나이:%d\n",hms.sno,hms.name,hms.score,entry.getValue());
		    }
		}
		
		System.out.println("총 엔트리 수 : "+map.size());
		
		//객체를 값으로 넣는방법
		Map<Integer, HashMapStudent> map2 = new HashMap<Integer, HashMapStudent>();
		map2.put(123, new HashMapStudent(123, "통장번호/계좌주/금액", 100));
		
		//값에 있는 객체의 값을 꺼내는 방법
		HashMapStudent hm = map2.get(123);
		System.out.println(hm.sno+" "+hm.name+" "+hm.score);
		
		System.out.println("총 엔트리 수 : "+map2.size());
		
	}

}
