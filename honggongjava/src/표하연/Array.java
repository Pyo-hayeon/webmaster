package 표하연;

public class Array {

	public static void main(String[] args) {
		//1번문제
		int[] nums = new int[10];
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<10; i++) {
			nums[i] = (int)(Math.random()*10)+1;
		}
		System.out.print("배열의 값 : ");
		for(int ele : nums) {
			System.out.print(ele+" ");
			sum += ele;
			if(max<ele) {
				max = ele;
			}
			if(min>ele) {
				min = ele;
			}
		}
		double avg = (double)sum/nums.length;
		System.out.println("\n배열의 합은 : "+sum+" 평균은 : "+avg);
		System.out.println("배열의 최소는 : "+min+" 최대는 : "+max);
		System.out.println();
		
		
		
		//2번 문제
		int[][] nums1 = {
				{1,2,3},
				{1,2},
				{1},
				{1,2,3}
		};
		for(int i=0; i<nums1.length; i++) {
			for(int j=0; j<nums1[i].length; j++) {
				System.out.print(nums1[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		//3번 문제
		int cnt = 0;
		int[][] members = new int[3][10];
		for(int i=0; i<members.length; i++) {
			for(int j=0; j<members[i].length; j++) {
				members[i][j] = (int)(Math.random()*2);
				if(members[i][j]==1) {
					cnt++;
				}
			}
		}
		for(int i=0; i<members.length; i++) {
			for(int j=0; j<members[i].length; j++) {
				System.out.print(members[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("현재 관객 수는 "+cnt+"명");
		System.out.println();
		
		
		
		//4번 문제
		int[][] students = new int[3][5];
		double[] grades = new double[3];
		sum = 0;
		avg = 0;
		for(int i=0; i<students.length; i++) {
			for(int j=0; j<students[i].length; j++) {
				students[i][j] = (int)(Math.random()*51)+50;
				sum += students[i][j];
			}
			avg = (double)sum/students[i].length;
			grades[i] = avg;
			sum = 0;
		}
		for(int i=0; i<students.length; i++) {
			for(int j=0; j<students[i].length; j++) {
				System.out.print(students[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=0; i<grades.length; i++) {
			System.out.println((i+1)+"번 학생의 평균 = "+grades[i]);
		}
		System.out.println();
		
		
		
		//5번 문제
		String[] Shapes = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] cardNums = {"2","3","4", "5", "6","7","8","9","10","Jack","Queen","King","Ace"};
		
		for(int i=0; i<5; i++) {
			String cardStr = "";
			int temp = (int)(Math.random()*Shapes.length);
			cardStr += Shapes[temp]+"의";
			temp = (int)(Math.random()*cardNums.length);
			cardStr += " "+cardNums[temp]+"\n";
			System.out.print(cardStr);
		}
		System.out.println();
		
		
		
		System.out.println("★ 6번문제 다시 푼거");
		//6번문제 -- 추가 알고리즘
		int[][] nArr = new int[3][5];
		for(int i=0; i<5; i++) {
			int iArr = (int)(Math.random()*3);
			int jArr = (int)(Math.random()*5);
			if(nArr[iArr][jArr]!=1) {
				nArr[iArr][jArr] = 1;
			}else {
				i--;
			}
		}
		for(int[] row : nArr) {
			for(int ele : row) {
				System.out.print(ele+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		//6번문제 (내가짠 알고리즘)
		//독립시행이라고해도 처음꺼부터 2개중 1개여서 확률적으로 뒷쪽배열은 1이되기 힘듬
		//그래서 실패 ㅠㅠ!!
		System.out.println("★ 6번문제 : 처음 짰었던 코드");
		int[][] doubleArr = new int[3][5];
		int oneCount = 5;
		int deathCount = doubleArr.length * doubleArr[0].length;
		for(int i=0; i<doubleArr.length; i++) {
			for(int j=0; j<doubleArr[i].length; j++) {
				deathCount--;
				doubleArr[i][j] = (int)(Math.random()*2);
				if(oneCount>deathCount) {
					doubleArr[i][j]=1;
				}else {
					if(doubleArr[i][j]==1 && oneCount!=0) {
						oneCount--;
					}else {
						doubleArr[i][j]=0;
					}
				}
				System.out.print(doubleArr[i][j]+" ");
			}
			System.out.println();
		}
	
		
	}//main

}//class