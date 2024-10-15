package chap07_books;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean end = true;
		int booknum = 0;
		Book[] bk = new Book[booknum];
		
		while(end) {			
			System.out.println("--------------------------------------------------");
			System.out.println("1.책개수입력 | 2.도서입력 | 3.목록조회 | 4.도서분석 | 5.종료");
			System.out.println("--------------------------------------------------");
			System.out.print("메뉴를 선택해주세요 >");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
				case 1: {
					System.out.print("도서 갯수를 입력 해주세요 >");
					booknum = Integer.parseInt(sc.nextLine());
					break;
				}
				case 2: {
					if(booknum > 0) {
						bk = new Book[booknum];
						for(int i=0; i<bk.length; i++) {
							System.out.print((i+1)+"번째 책 제목을 입력해주세요 >");
							String bname = sc.nextLine();
							System.out.print((i+1)+"번째 책 번호를 입력해주세요 >");
							int bnum = Integer.parseInt(sc.nextLine());
							System.out.print((i+1)+"번째 책 가격을 입력해주세요 >");
							int bprice = Integer.parseInt(sc.nextLine());
							//외부 필드 생성자 접근 안하고
							//bk[i] = new Book(bname, bnum, bprice);
							bk[i] = new Book();
							bk[i].booksetter(bname, bnum, bprice);
						}
					}else {
						System.out.println("도서 갯수먼저 입력 해주세요!");
					}
					break;
				}
				case 3: {
					if(booknum > 0 && bk.length != 0) {
						for(Book ele : bk) {
							System.out.println(ele.bookgetter());
						}
//						for(int i=0; i<booknum; i++) {
//							String booklist = bk[i].bookgetter();
//							System.out.println(booklist);
//						}
					}else {
						System.out.println("도서 갯수 또는 책 정보 먼저 입력 해주세요!");
					}
					break;
				}
				case 4: {
					if(booknum > 0 && bk.length != 0) {
						int max = Integer.MIN_VALUE;
						int sum = 0;
						int price;
						for(int i=0; i<booknum; i++) {
							price = bk[i].pricegetter(); 
							sum += price;
							if(price > max) {
								max = price;
							}
						}
						System.out.println("도서 평균 가격 :"+(sum/booknum)+"원 | 최대가격 :"+max+"원");
					}else {
						System.out.println("도서 갯수 또는 책 정보 먼저 입력 해주세요!");
					}
					break;
				}
				case 5: {
					end = false;
					System.out.println("프로그램 종료");
					break;
				}
				default: {
					System.out.println("값을 잘못 입력 했습니다.");
					break;
				}
			}
		}
		
		
		
		
	}

}
