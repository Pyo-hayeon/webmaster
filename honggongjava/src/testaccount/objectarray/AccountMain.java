package testaccount.objectarray;

import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {
		boolean stop = true;
		Scanner sc = new Scanner(System.in);
		AccountDao ad = new AccountDao();
		
		while(stop) {
			
			System.out.println("------------------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.계좌입금 | 4.계좌출금 | 5.계좌삭제 | 6.종료");
			System.out.println("------------------------------------------------------------");
			System.out.print("메뉴를 입력해주세요 >");
			int key = Integer.parseInt(sc.nextLine());
			
			switch (key) {
				case 1: {
					System.out.println("---계좌생성---");
					System.out.print("계좌번호 입력>");
					String acNo = sc.nextLine();
					
					System.out.print("계좌주 입력>");
					String name = sc.nextLine();
					
					System.out.print("초기금액 입력>");
					int balence = Integer.parseInt(sc.nextLine());
					
					for(int i=0; i<ad.ac.length; i++) {
						if(ad.ac[i]==null) {
							for(int j=0; j<ad.ac.length; j++) {
								
								//값이 있는 경우 
								if(ad.ac[j]!=null) {
									if(ad.ac[j].getAcNo().equals(acNo)) {
										System.out.println("계좌번호가 존재합니다 계좌 계설 불가");
										break;
									}
								//값이 없고 중복이 없이 여기까지 올경우 삽입
								}else {
									ad.ac[j] = new Account(acNo, name, balence);
									System.out.println("계좌 생성 완료");
									break;
								}
								
							}//for(int j=0; j<ad.ac.length; j++)
							break;
						}else {
							if(i==(ad.ac.length-1)) {
								System.out.println("더이상 계좌 개설 불가합니다");
							}
						}
					}//for(int j=0; j<ad.ac.length; j++)
					break;
				}
				
				
				case 2: {
					System.out.println("---계좌목록---");
					for(Account ele : ad.ac) {
						if(ele != null) {
							System.out.println(ele.toString());							
						}else {
							break;
						}
					}
					break;
				}
				
				case 3: {
					System.out.println("---계좌 입금---");
					System.out.print("계좌번호 입력>");
					String acNo = sc.nextLine();
					for(Account ele : ad.ac) {
						if(ele != null) {
							if(ele.getAcNo().equals(acNo)) {
								System.out.print("입금하실 금액 입력>");
								int balence = Integer.parseInt(sc.nextLine());
								if(ele.MaxNin((ele.getBalence()+balence))) {
									System.out.println("입금 완료! 현재잔액 : "+ele.getBalence());
								}else {
									System.out.println("최대 입금액 100만원을 넘을 수 없습니다");
								}
								break;
							}else {
							}
						}else {
							System.out.println("일치하는 계좌번호가 없습니다.");
							break;
						}
					}
					break;
				}
				
				case 4: {
					System.out.println("---계좌 출금---");
					System.out.print("계좌번호 입력>");
					String acNo = sc.nextLine();
					for(Account ele : ad.ac) {
						if(ele != null) {
							if(ele.getAcNo().equals(acNo)) {
								System.out.print("출금하실 금액 입력>");
								int balence = Integer.parseInt(sc.nextLine());
								if(ele.MaxNin((ele.getBalence()-balence))) {
									System.out.println("출금 완료! 현재잔액 : "+ele.getBalence());
								}else {
									System.out.println("출금 잔액이 부족합니다");
								}
								break;
							}else {
							}
						}else {
							System.out.println("일치하는 계좌번호가 없습니다.");
							break;
						}
					}
					break;
				}
				
				case 5: {
					System.out.println("---계좌 삭제---");
					System.out.print("계좌번호 입력>");
					String acNo = sc.nextLine();
					for(int i=0; i<ad.ac.length; i++) {
						if(ad.ac[i] != null) {
							//삭제 계좌 확인
							if(ad.ac[i].getAcNo().equals(acNo)) {
								
								for(int j=i; j<ad.ac.length; j++) {
									//다음 계좌가 존재하면 계자 정보 받아와서 현재 계좌에 삽입
									if(ad.ac[j+1] != null) {
										String acNo1 = ad.ac[j+1].getAcNo();
										String name = ad.ac[j+1].getName();
										int balence = ad.ac[j+1].getBalence();
										ad.ac[j] = new Account(acNo1, name, balence);
										
									//다음계좌가 없으면 종료
									}else {
										ad.ac[j] = null;
										break;
									}
								}
								
							break;	
							}else {
							}
						}else {
							System.out.println("일치하는 계좌번호가 없습니다.");
							break;
						}
					}
					break;
				}
				
				
				case 6: {
					System.out.println("프로그램 종료");
					stop = false;
					break;
				}
				default: {
					System.out.println("값을 잘못 입력 했습니다.");
					break;
				}
				
				
			}//switch (key)
			
		}//while(stop)
		
		sc.close();

	}

}
