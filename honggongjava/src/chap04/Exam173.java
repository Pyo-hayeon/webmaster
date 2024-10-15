package chap04;

public class Exam173 {

	public static void main(String[] args) {
		// 50에서 100까지 3의 배수 합 구하기
		// 3의 배수 출력, 마지막에 3의 배수합 출력
		// 3의 배수 갯수
		int num = 0;
		int y = 0;
		for(int i = 50; i<=100; i++){
			if(i%3==0) {
				System.out.println("3의 배수 : "+i+"\t");
				num += i;
				y++;
			}
		}//for(int i = 50; i<=100; i++){
		System.out.println("50부터 100까지 3의배수 = "+num+"이고 갯수는 : "+y);
		System.out.println("");
		// 1에서 n까지의 합이 300이 넘는 순간 n값 구하기
		// 7의 배수의 합이 300이 넘는 순간 7의 배수 찾기
		int i = 0;
		int j = 0;
		while(true) {
			i++;
			if(i%7==0) {
				j += i;
				if(j>=300) {
					break;
				}
			}
		}
		
		//와... 알고리즘 스마트하다 ㄷㄷ
		int su = 0;
		int sum = 0;
		while(sum<=300) {
			su += 7;
			sum += su;
		}
		
		su = 0;
		sum = 0;
		while(true) {
			su += 7;
			sum += su;
			if(sum>=300) {break;}
		}
		
		System.out.println("7배수 총합은 : "+sum+"이고 넘는 7의 배수는 : "+su);
		System.out.println("7배수 총합은 : "+j+"이고 넘는 7의 배수는 : "+i);
		
		
		//구구단 중첩 for문
		for(int i1=2; i1<=9; i1++) {
			System.out.println("===="+i1+"단====");
			for(int j1=1; j1<=9; j1++) {
				System.out.printf("%d X %d = %2d\n", i1, j1, (j1*i1));
			}
		}
		System.out.println();
		
		for (int i3=1; i3<=9; i3++) {
			System.out.print("===="+i3+"단====\t");
		}
		System.out.println();
		for(int i2=1; i2<=9; i2++) {
			for(int j2=2; j2<=9; j2++) {
				System.out.printf("%d X %d = %2d\t", j2, i2, (j2*i2));
			}
			System.out.println();
		}
		System.out.println();
		
		String str = "";
		String str1 = "";
		for(int i4=1; i4<=9; i4++) {
			for(int j4=2; j4<=9; j4++) {
				if(i4==1) {
					str += "===="+j4+"단====\t";
				}
				str1 += j4+" X "+i4+" = "+(j4*i4)+"\t";
			}
			if(i4==1) {
				System.out.println(str);
				System.out.println(str1);
			}else {
				System.out.println(str1);
			}
			str1 ="";
		}

		
	}//main

}//Exam173
