package 표하연;

import java.util.Scanner;

public class AccountMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean stop = true;
		Account[] ac = new Account[100];
		//int mainNum = 0;

		
		while(stop) {
			System.out.println("-----------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-----------------------------------------");
			System.out.print("선택> ");
			int menuNum = Integer.parseInt(sc.nextLine());
			
			switch (menuNum) {
				case 1: {
					int flag = 0;
					for(int i=0; i<ac.length; i++) {
						if(ac[i]==null) {
							System.out.println("-----");
							System.out.println("계좌생성");
							System.out.println("-----");
							System.out.print("계좌번호 : ");
							String ano = sc.nextLine();
							System.out.print("계좌주 : ");
							String owner = sc.nextLine();
							System.out.print("초기입금액 : ");
							int balence = Integer.parseInt(sc.nextLine());
							ac[i] = new Account(ano, owner, balence);
							flag++;
							break;
						}else {
							//System.out.println("여기에 값있으니까 못넣음");
						}
					}
					if(flag==0) {
						System.out.println("더이상 계좌 계설이 불가능합니다");
					} 
					
//					ac[mainNum] = new Account();
//					System.out.println("-----");
//					System.out.println("계좌생성");
//					System.out.println("-----");
//					if(mainNum<100) {
//						System.out.print("계좌번호 : ");
//						ac[mainNum].anoSetter(sc.nextLine());
//						System.out.print("계좌주 : ");
//						ac[mainNum].ownerSetter(sc.nextLine());
//						System.out.print("초기입금액 : ");
//						ac[mainNum].balenceSetter(Integer.parseInt(sc.nextLine()));
//						mainNum++;
//					}else{
//						System.out.println("더이상 계좌를 만들 수 없습니다");
//					}	
					break;
				}
				case 2: {
					System.out.println("-----");
					System.out.println("계좌목록");
					System.out.println("-----");
					
					for(Account ele : ac) {
						if(ele!=null) {
							System.out.printf("계좌목록 : %s\t계좌주 : %s\t잔액 : %d\n",
											ele.anoGetter(),ele.ownerGetter(),ele.balenceGetter());
						}else {
							break;
						}
					}
					
//					for(int i=0; i<mainNum; i++) {
//						System.out.printf("계좌목록 : %s\t계좌주 : %s\t잔액 : %d\n",
//								ac[i].anoGetter(),ac[i].ownerGetter(),ac[i].balenceGetter());
//					}
					break;
				}
				case 3: {
					System.out.println("-----");
					System.out.println("입금");
					System.out.println("-----");
					System.out.print("계좌번호 : ");
					String yourAno = sc.nextLine();
					int flag = 0;
					
					for(Account ele : ac) {
						//데이터가 있고 해당 값이 위에 값이랑 같다면
						if(ele!=null && yourAno.equals(ele.anoGetter())) {
							System.out.print("입금 : ");
							int balence = Integer.parseInt(sc.nextLine());
							balence = ele.balenceGetter()+balence;
							if(ele.setBalence(balence)) {
								System.out.println("입금이 성공되었습니다. 잔액 : "+ele.balenceGetter());
							}else {
								System.out.println("입금 실패!!! 잔액확인!!! : "+ele.balenceGetter());
							}
							flag++;
						}
					}
					
					
//					int flag = 0;
//					for(int i=0; i<mainNum; i++) {
//						if(yourAno.equals(ac[i].anoGetter())) {
//							System.out.print("입금 : ");
//							int balence = Integer.parseInt(sc.nextLine());
//							balence = ac[i].balenceGetter()+balence;
//							if(ac[i].setBalence(balence)) {
//								System.out.println("입금이 성공되었습니다. 잔액 : "+ac[i].balenceGetter());
//							}else {
//								System.out.println("입금 실패!!! 잔액확인!!! : "+ac[i].balenceGetter());
//							}
//							flag++;
//							break;
//						}else {
//						}
//					}
					
					
					if(flag==0) {
						System.out.println("계좌번호가 잘못 되었습니다.");
					}
					break;
				}
				case 4: {
					System.out.println("-----");
					System.out.println("출금");
					System.out.println("-----");
					System.out.print("계좌번호 : ");
					String yourAno = sc.nextLine();
					int flag = 0;
					
					for(Account ele : ac) {
						//데이터가 있고 해당 값이 위에 값이랑 같다면
						if(ele!=null && yourAno.equals(ele.anoGetter())) {
							System.out.print("출금액 : ");
							int balence = Integer.parseInt(sc.nextLine());
							balence = ele.balenceGetter()-balence;
							if(ele.setBalence(balence)) {
								System.out.println("출금이 성공되었습니다. 잔액 : "+ele.balenceGetter());
							}else {
								System.out.println("출금이 실패!!! 잔액확인!!! : "+ele.balenceGetter());
							}
							flag++;
							break;
						}
					}
					
						
//					for(int i=0; i<mainNum; i++) {
//						if(yourAno.equals(ac[i].anoGetter())) {
//							System.out.print("출금액 : ");
//							int balence = Integer.parseInt(sc.nextLine());
//							balence = ac[i].balenceGetter()-balence;
//							if(ac[i].setBalence(balence)) {
//								System.out.println("출금이 성공되었습니다. 잔액 : "+ac[i].balenceGetter());
//							}else {
//								System.out.println("출금이 실패!!! 잔액확인!!! : "+ac[i].balenceGetter());
//							}
//							flag++;
//							break;
//						}else {
//						}
//					}
					
					
					if(flag==0) {
						System.out.println("계좌번호가 잘못 되었습니다.");
					}
					break;
				}
				case 5: {
					stop = false;
					System.out.println("프로그램 종료");
					break;
				}
				default: {
					System.out.println("값을 잘못 입력 했습니다");
					break;
				}
			}
			
		}
		
	}
}
