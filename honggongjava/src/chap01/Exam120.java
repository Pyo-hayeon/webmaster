package chap01;
import java.util.Scanner;

public class Exam120 {

	public static void main(String[] args) {
		//1번문제
		String str = "감자봐";
		int it = 25;
		String tel1 = "010", tel2 = "8521", tel3 = "6704";
		System.out.println(str);
		System.out.print(it+"\n");
		System.out.printf("%s-%s-%s",tel1, tel2, tel3);
		
		//2번문제
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 수 : ");
		String str1 = sc.nextLine();
		
		System.out.print("두번째 수 : ");
		String str2 = sc.nextLine();
		
		int su1 = Integer.parseInt(str1);
		int su2 = Integer.parseInt(str2);
		int result = su1 + su2;
		System.out.println(result);
		
		//3번문제
		System.out.print("이름 : ");
		String str3 = sc.nextLine();
		System.out.print("주민번호 : ");
		String str4 = sc.nextLine();
		System.out.print("전화번호 : ");
		String str5 = sc.nextLine();
		
		System.out.println("이름은 : " + str3);
		System.out.println("주민번호는 : " + str4);
		System.out.println("전화번호는 : " + str5);
		
		
		//두수를 입력 받아서 큰수 - 작은수
		System.out.print("1번수 입력 : ");
		int su3 = sc.nextInt();
		System.out.print("2번수 입력 : ");
		int su4 = sc.nextInt();
		int result3;
		if(su3>su4) {
			result3 = su3 - su4;
		}else {
			result3 = su4 - su3;
		}
		System.out.println(result3);
		
		
		sc.close();
	}

}
