package test13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StudentHashMapMain {

	public static void main(String[] args) {
		
		//각학생의 평균의 평균 점수
		int avg = 0;
		//각학생 평균중에 가장 높은 평균
		double max = Integer.MIN_VALUE;
		//평균점수가 가장 높은 학생
		String name = null;
		//각 학생들의 평균 합
		double avgsum = 0;

		Map<String, StudentHashMap> map = new HashMap<>();
		
		map.put("표하연", new StudentHashMap(63, 65, 74));
		map.put("배땡땡", new StudentHashMap(65, 73, 77));
		map.put("박땡땡", new StudentHashMap(74, 75, 83));
		map.put("김땡땡", new StudentHashMap(75, 83, 87));
		map.put("권땡땡", new StudentHashMap(93, 97, 94));
		
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			System.out.println("현재확인 중인학생 : "+str);

			//객체 않에 들어 있는 필드갯수 [ 이런거 안쓰지 싶은데 알아두면 좋을꺼같아서 ]
			int count = map.get(str).getClass().getDeclaredFields().length;
			double sum = (double)(map.get(str).engnum + map.get(str).kornum + map.get(str).matnum);
			
			System.out.printf("현재확인 중인학생 평균 : %.2f\n",sum/count);
			
			if((sum/count)>max) {
				max = (sum/count);
				name = str;
			}
			avgsum += sum/count;
			System.out.println();
		}
		
		System.out.println("최고 학생 : "+name);
		System.out.printf("최고 평균 : %.2f\n",max);
		System.out.printf("학생들 평균 : %.2f\n",avgsum/map.size());

	}

}
