package chap04;

public class Exam162 {

	public static void main(String[] args) {
		//주사위 2개를 던져서 2개의 합이 5가 되면 종료 - game over
		// 5가 아니면 2개 주사위 눈 표시
		// 몇번 만에 나오는지 체크
		int i = 0;
		while(true) {
			int num1 = (int)(Math.random()*6)+1;
			int num2 = (int)(Math.random()*6)+1;
			System.out.printf("%d , %d = %d \n",num1, num2, (num1+num2));
			i++;
			if(num1+num2==5) {
				System.out.println(i+"번 만에 게임 오버");
				break;
			}else {
			}
		}//while(true) {
		
		//주사위 눈이 1이면 1등 ~ 6이면 6등
		int num3 = (int)(Math.random()*6)+1;
		
		if(num3==1) {
			System.out.println("1등");
		}else if(num3==2) {
			System.out.println("2등");
		}else if(num3==3) {
			System.out.println("3등");
		}else if(num3==4) {
			System.out.println("4등");
		}else if(num3==5) {
			System.out.println("5등");
		}else {
			System.out.println("꼴지");
		}//if(num3==1)
		
		switch (num3) {
		case 1: System.out.println("1등"); break;
		case 2: System.out.println("2등"); break;
		case 3: System.out.println("3등"); break;
		case 4: System.out.println("4등"); break;
		case 5: System.out.println("5등"); break;
		default:System.out.println("꼴찌"); break;
		}//switch (num3)
		
		System.out.println(num3+"등");
		
		// 랜덤 = 곱수 = 최종값 - 초기값 + 1
		// 50~100까지 수를 발생
		// 90이상이면 A, 80이상이면 B, C D F
		// break 없을때 순차적으로 케이스 실행하는거 보기위한거
		int num4 = (int)(Math.random()*51)+50;
		switch (num4/10) {
		//case 10,9: System.out.println("A"); break;
		case 10:
		case 9: System.out.println("A"); break;
		case 8: System.out.println("B"); break;
		case 7: System.out.println("C"); break;
		case 6: System.out.println("D"); break;
		default:System.out.println("F"); break;
		}//switch (num4S)
		System.out.println(num4 +" " + (num4/10));

	}//main
}//class Exam162