package chap05;

import java.util.Arrays;
import java.util.Scanner;

public class Exam214 {

	public static void main(String[] args) {
		//2차원 배열
		int[][] scores = {
				{10,20,30},
				{40,50,60}
		};
		System.out.println(scores[1][1]); // 50
		System.out.println();
		
		for(int i=0; i<scores.length; i++) {
			for(int j=0; j<scores[i].length; j++) {
				System.out.println(scores[i][j]+" ");
			}
			System.out.println();
		}
		
		// 2*3 배열을 선언하고
		// 1에서 10까지 무작위 수를 입력하세요
		int[][] nums = new int[2][3];
		
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[i].length; j++) {
				nums[i][j] =(int)(Math.random()*10)+1;
				//System.out.print(nums[i][j]+" ");
			}
		}
		for(int i=0; i<nums.length; i++) {
			for(int j : nums[i]) {
				System.out.print(j+" ");
			}
			System.out.print("\t");
		}
		System.out.println();
		
		
		//항상된 for 문
		int[] su = {10,200,30,40,-50,777,555};
		//배열의 합, 최대값, 최소값
		//항상된 for문 이용
		int sum = 0;
		int max = Integer.MIN_VALUE;	//해당 타입중에 최소값
		int min = Integer.MAX_VALUE;	//해당 타입중에 최대값
		for(int ele: su) {
			if(max<ele) {
				max = ele;
			}
			if(min>ele) {
				min = ele;
			}
			sum += ele;
		}
		System.out.println(sum+" "+max+" "+min+" ");
		System.out.println();
		
		
		
		
		
		
		
		
	}

}
