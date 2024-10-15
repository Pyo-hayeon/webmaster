package testaccount.arraylist;

import java.util.Scanner;


public class AccountArrayListMain {

	public static void main(String[] args) {
		
		boolean stop = true;
		Scanner sc = new Scanner(System.in);
		AccountArrayDao adao = new AccountArrayDao();
		
		while(stop) {
			
			System.out.println("------------------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.계좌입금 | 4.계좌출금 | 5.계좌삭제 | 6.종료");
			System.out.println("------------------------------------------------------------");
			System.out.print("메뉴를 입력해주세요 >");
			int key = Integer.parseInt(sc.nextLine());
			
			switch (key) {
				case 1: {
					System.out.println("---계좌 생성---");
					
					System.out.print("계좌번호 입력>");
					String acNo = sc.nextLine();
					
					System.out.print("계좌주 입력>");
					String name = sc.nextLine();
					
					System.out.print("초기금액 입력>");
					int balence = Integer.parseInt(sc.nextLine());
					
					if(adao.insetAccount(acNo, name, balence)) {
						System.out.println("계좌 생성 완료");
					}else {
						System.out.println("계좌 생성 실패");
					}
					
					break;
				}
				
				case 2: {
					System.out.println("---계좌 목록---");
					for(AccountArrayList ac : adao.list) {
						System.out.println(ac.toString());
					}
					break;
				}
				
				case 3: {
					System.out.println("---계좌 입금---");
					System.out.print("계좌번호 입력>");
					String acNo = sc.nextLine();
					
					System.out.print("입금 금액 입력>");
					int balence = Integer.parseInt(sc.nextLine());
					
					if(adao.minmax(acNo, balence, 1)) {
						System.out.println("입금 성공");
					}else {
						System.out.println("입금 실패");
					}
					break;
				}
				
				case 4: {
					System.out.println("---계좌 출금---");
					System.out.print("계좌번호 입력>");
					String acNo = sc.nextLine();
					
					System.out.print("출금 금액 입력>");
					int balence = Integer.parseInt(sc.nextLine());
					if(adao.minmax(acNo, balence, 2)) {
						System.out.println("출금 성공");
					}else {
						System.out.println("출금 실패");
					}
					break;
				}
				
				case 5: {
					System.out.println("---계좌 삭제---");
					System.out.print("계좌번호 입력>");
					String acNo = sc.nextLine();
					
					if(adao.delete(acNo)) {
						System.out.println("계좌 삭제 성공");
					}else {
						System.out.println("계좌 삭제 실패");
					}
					break;
				}
				
				case 6: {
					System.out.println("프로그램 종료");
					stop = false;
					 break;
				}
				default: {
					System.out.println("값을 잘못 입력 했습니다");
					break;
				}
			}
		}
		
		sc.close();
		

	}

}
