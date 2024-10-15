package chap04;
import java.util.Scanner;

public class Exam182 {

	public static void main(String[] args) {
		//2번
		//3번
		//4번
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++){
				if((4*i) + (5*j) == 60) {
					System.out.printf("x의 값은 %d이고 y의 값은 %d 이다\n",i ,j);
				}
			}
		}
		System.out.println();
		
		//5번
		String str1 = "";
		for(int i=0; i<=3; i++) {
			str1 += "*";
			System.out.println(str1);
		}
		System.out.println();
		
		//6번
		str1 = "";
		String str2 = "";
		for(int i=0; i<=3; i++) {
			if(i!=0) {
				str1 += " ";
			}
			for(int j=i; j<=3; j++) {
				str2 += "*";
			}
			System.out.println(str1+str2);
			str2 = "";
		}
		System.out.println();
		
		str1 = "";
		str2 = "";
		for(int i=0; i<=3; i++) {
			str1 += "*";
			for(int j=i; j<=2; j++) {
				str2 += " ";
			}
			System.out.println(str2+str1);
			str2 = "";
		}
		System.out.println();
		
		
		
		str1 = "";
		str2 = "";
		for(int i=0; i<=3; i++) {
			for(int j=0; j<=3; j++) {
				if(i<=j) {
					str1 += "*";
				}else {
					str1 = " ";
				}
			}
			System.out.println(str1);
		}
		System.out.println();
		
		
		
		
//		str1 = "";
//		for(int i=1; i<5; i++) {
//			str1 += "*";
//			System.out.printf("%4s\n",str1);
//		}
		
		
		//7번
		//Scanner sc = new Scanner(System.in) 문자로 받았으면
		//다음 받는곳도 문자여야함
		boolean run = true;
		int balance = 0;
		int temp;
		try (Scanner sc = new Scanner(System.in)) {
			while(run) {
				System.out.println("------------------------------");
				System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
				System.out.println("------------------------------");
				System.out.print("숫자를 입력해주세요 > ");
				int num = Integer.parseInt(sc.nextLine());
				temp = 0;
				switch (num) {
					case 1:{
						System.out.print("얼마 입금하시겠습니까? > ");
						temp = Integer.parseInt(sc.nextLine());
						balance += temp;
						System.out.println(temp+"원 입금했습니다\n");
						break;
					}
					case 2:{
						System.out.print("얼마 출금 하시겠습니까?(현재잔고:"+balance+"원) > ");
						temp = Integer.parseInt(sc.nextLine());
						if(temp > balance) {
							System.out.println("잔액이 부족합니다. 출금가능액 : "+balance+"원\n");
						}else {
							balance -= temp;
							System.out.println(balance+"원 남았습니다\n");
						}
						break;
					}
					case 3:{
						System.out.print("현재 잔고는 ");
						System.out.println(balance+"원 입니다\n");
						break;
					}
					case 4:{
						System.out.println("종료 되었습니다.");
						run = false;
						break;
					}
					default:{
						System.out.println("정확한값을 입력하세요"); break;
					}
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
