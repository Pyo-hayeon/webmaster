package chap13;

import java.util.*;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;

//HashMap 임포트가안되서 찾아봐야함 하는법
public class HashMapMain {
	public static void main(String[] args) {
		Map<String, Integer>map = new HashMap<String, Integer>();
		
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		System.out.println("총 엔트리 수: "+map.size());
		
		System.out.println("\t홍길동 : "+map.get("홍길동"));
		System.out.println();
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t"+key+" : "+value);
		}
		System.out.println();
		
		map.remove("홍길동");
		System.out.println("총 엔트리 수: "+map.size());
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t"+key+" : "+value);
		}
		System.out.println();
		
		System.out.println();
		for(var entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println();
		
		map.clear();
		System.out.println("총 엔트리 수: "+map.size());
		
		
	}
}
