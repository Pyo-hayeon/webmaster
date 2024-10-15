package 표하연;

import java.util.Scanner;

public class Doself {

	public static void main(String[] args) {
		
		//1. 윤년 계산 프로그램
		Scanner sc = new Scanner(System.in);
		System.out.print("##년도 입력 : ");
		int year = sc.nextInt();
		if(year%4==0 && year%100!=0 || year%400==0) {
			System.out.println(year+"년은 윤년입니다.");			
		}else {
			System.out.println(year+"년은 평년입니다.");
		}
		System.out.println();

	
		
		
		//2. 동전 교환 프로그램
		int temp;
		int last_money;
		System.out.print("##교환할 금액 : ");
		int money = sc.nextInt();
		last_money = money;
		temp = money/500;
		System.out.println("500원 짜리 : "+temp+"개");
		money = money - (500*temp);
		
		temp = money/100;
		System.out.println("100원 짜리 : "+temp+"개");
		money = money - (100*temp);
		
		temp = money/50;
		System.out.println("50원 짜리 : "+temp+"개");
		money = money - (50*temp);
		
		temp = money/10;
		System.out.println("10원 짜리 : "+temp+"개");
		money = money - (10*temp);
		System.out.println("교환 금액 : "+last_money+"원");
		System.out.println("남은 금액 : "+money+"원");
		System.out.println();
		
		
		
		
		//3. 숫자 추측 게임
		int num = (int)(Math.random()*100) + 1;
		//System.out.println("힌트(나중에 주석처리 필요) : "+num);
		while(true) {
			System.out.print("업다운겜 숫자입력 : ");
			int goodnum = sc.nextInt();
			if(num >= goodnum) {
				if(num==goodnum) {
					System.out.println("축하합니다!!");
					break;
				}
				System.out.println("up하세요!!");
			}else {
				System.out.println("down하세요!!");
			}
		}
		System.out.println();
		
		
		
		//4. 구구단 프로그램
		for(int i=1; i<=9; i++) {
			System.out.printf("    %s단     \t",i);
		}
		System.out.println();
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.printf("%s x %s = %2s\t",i,j,(i*j));
			}
			System.out.println();
		}
		System.out.println();
		
		
		//5. 섭씨-화씨 온도 변환
		boolean tf = true;
		while(tf) {
			System.out.println("------------------");
			System.out.println("1. 화씨 => 섭씨");
			System.out.println("2. 섭씨 => 화씨");
			System.out.println("3. 종료");
			System.out.println("------------------");
			System.out.print("▶번호 선택 : ");
			int num1 = sc.nextInt();
			switch (num1) {
			case 1:{
				System.out.print("▶화씨 온도 입력 : ");
				int temper = sc.nextInt();
				System.out.printf(" 섭씨온도 = %.6f\n",5.0/9.0*(temper-32));
				break;
			}
			case 2:{
				System.out.print("▶섭씨 온도 입력 : ");
				int temper = sc.nextInt();
				System.out.printf(" 화씨온도 = %.6f\n",(((9.0/5.0)*temper)+32));
				break;
			}
			case 3:{
				tf = false;
				System.out.println("program end");
				break;
			}
			default:
				System.out.println("값이 잘못 입력됨");
				break;
			}
		}
		System.out.println();
		
		
		
		/*
		나 | 컴			가위(0)	바위(1)	보(2)
		가위(0+1%3)=1			컴승		사람승	
		바위(1+1%3)=2	사람승			컴승	
		보(2+1%3)=0		컴승		사람승	  
		 */
		//6.가위, 바위, 보 게임
		tf = true;
		while(tf) {
			int com =(int)(Math.random()*3);
			System.out.print("## 가위(0) 바위(1) 보(2) : ");
			int mjb = sc.nextInt();
			if(mjb<=2) {
				if(mjb==com) {
					System.out.printf("사람 %s, 컴 %s 비겼음\n", mjb, com);
				}else {
					if((mjb+1)%3 == com) {
						System.out.printf("사람 %s, 컴 %s 컴 승리\n", mjb, com);
					}else {
						System.out.printf("사람 %s, 컴 %s 사람 승리\n", mjb, com);
					}
				}
			}else{
				System.out.println("game over");
				tf = false;
			}
		}
		System.out.println();
		
		
		
		//7. 3 6 9 게임
		String temp1 = "";
		for(int i=1; i<=50; i++) {
			if(i%10==3 || i%10==6 || i%10==9) {
				temp1 += "♥";
			}
			if(i/10==3 || i/10==6 || i/10==9) {
				temp1 += "♥";
			}
			if(temp1.equals("")) {
				temp1 = String.valueOf(i);
			}
			if(i%10!=0) {
				System.out.print(temp1+"\t");
			}else {				
				System.out.print(temp1+"\n");
			}
			temp1 = "";
		}
		
		
	}
}
