package chap01;
import java.util.Scanner;	//스캐너 클래스 임포트(꼭필요함)

public class Scanner118 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		
		System.out.print("문자열 입력 > ");
		str = sc.nextLine();
		System.out.println("입력 받은 문자열 : " + str);
		
		if(str=="q") {
			System.out.println("q입력됨");
		}else if(str.equals("q")) {
			System.out.println("진짜q입력");
		}else {
			System.out.println("같지않음");
		}
		
		//숫자
		System.out.print("숫자 입력 > ");
		int valInt = sc.nextInt();
		System.out.println("입력 받은 숫자 : " + valInt);
		//인트나 더블을 스캔으로 받아버리면 공백이 남아버리는데
		//그 공백을 그냥 먹여 버려야 다음 스캔이 작동함
		str = sc.nextLine();	
		
		System.out.print("문자열 입력 > ");
		str = sc.nextLine();
		System.out.println("입력 받은 문자열 : " + str);
		
		System.out.print("숫자 입력 > ");
		valInt = Integer.parseInt(sc.nextLine());
		System.out.println("입력 받은 숫자 : " + (valInt+100));
		
		sc.close(); //스캐너 객체 종료 (자원 낭비를 막기위해)
	}

}
