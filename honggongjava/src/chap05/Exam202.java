package chap05;

import java.util.Arrays;

public class Exam202 {

	public static void main(String[] args) {
		
		// String[] args 이거의 값은 Run메뉴에 있음
//		String args1 = args[1];
//		System.out.println(args1);
		
		//배열을 생성
		//배열을 이용하는 방법
		int[] scores = {83, 90, 87};
		
		System.out.println("scores[0] : "+scores[0]);
		System.out.println("scores[1] : "+scores[1]);
		System.out.println("scores[2] : "+scores[2]);
		
		//배열의 합
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += scores[i];
		}
		System.out.println("총합 : "+sum);
		double avg = (double)sum/scores.length;
		System.out.println("평균 : "+avg);
		
		//배열의 값 재입력
		for(int i=0; i<3; i++) {
			scores[i] = i;
		}
		System.out.println("scores[0] : "+scores[0]);
		System.out.println("scores[1] : "+scores[1]);
		System.out.println("scores[2] : "+scores[2]);
		System.out.println();
		
		//배열에 1에서 100까지 임의의 수 10개를 저장
		// 배열의 합과 평균(소수 첫째자리까지 나타냄),
		// 최대값, 최소값을 구하세요
		int[] num = new int[10]; // 힙 영역에 10개의 방을 잡아서 0의 기본값을 집어넣어라
		int max = 0;
		int min = 100;
		int sum1 = 0;
		for(int i=0; i<num.length; i++) {
			int rNum = (int)(Math.random()*100)+1;
			
//			for(int j=0; j<=i; j++) {
//				if(num[j]==rNum) {
//					i--;
//				}
//			}
			num[i] = rNum;
			
			sum1 += num[i];
			if(max < num[i]) {
				max = num[i];
			}else if(min > num[i]){
				min = num[i];
			}
		}
		//배열을 한줄에 출력해줌!! 대신 Arrays 클래스 임포트 해줘야함
		System.out.println(Arrays.toString(num));
		
		for (int value : num) {
			System.out.print(value+" ");
		}
		
		System.out.println();
		System.out.println("최소값은 : "+min);
		System.out.println("최대값은 : "+max);
		System.out.println("배열의합은 : "+sum1);
		double avg1 = (double)sum1/num.length;
		System.out.println("배열평균 : "+avg1);
		System.out.println();
		System.out.printf("sum=%d avg=%.1f max=%d min=%d",sum1, avg1, max, min);
		
	}
}
