package test13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapStudentMain {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("홍길동", 70);
		map.put("동장군", 75);
		map.put("성춘향", 80);
		map.put("이몽룡", 85);
		map.put("홍길동", 90);
		
		//키값을 이용해 접근 값을 반환
		System.out.println(map.get("홍길동"));
		
		//객체에 모든키를담아서 리턴한것을 Set 컬렉션에 집어넣음
		Set<String> keySet = map.keySet();
		//해당 셋컬렉션으로 반복자 생성
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			System.out.print(str+"\t");
			Integer value = map.get(str);
			System.out.println(value);
		}
		
		System.out.println("총 엔트리수 : "+map.size());
		
		//항상된 for문으로도 뽑을 수 있음
		for(String str : map.keySet()) {
			System.out.println(str + " " + map.get(str));
		}
	}

}
