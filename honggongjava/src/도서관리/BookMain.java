package 도서관리;

import java.util.List;
import java.util.Scanner;

public class BookMain {
	
	static Scanner sc = new Scanner(System.in);
	//객체호출(일반)
	//MemberDao mdao = new MemberDao();
	//싱글톤 상수값이 = new MemberDao() 이거여서 결국 같지만
	//외부 접근 못하게 막고
	static MemberDao mdao = MemberDao.getInstance();
	
	public static void main(String[] args) {
		
		Member member = null;
		
		//로그인
		while(true) {
			System.out.print("아이디를 입력해주세요 >>");
			String id = sc.nextLine();
			System.out.print("비밀번호를 입력해주세요 >>");
			String pw = sc.nextLine();
			
			//String message = mdao.checkMember(id, pw);
//			if(!message.equals("fail")) {
//				System.out.println(message+"님 환영합니다!");
//				break;
//			}else {
//				System.out.println("아이디 또는 비밀번호가 맞지 않습니다");
//			}			
			
			
			member = mdao.checkMember(id, pw);
			if(member!=null) {
				System.out.println(member.getMemberName()+"님 환영합니다");
				System.out.println("현재 권한 : "+member.getResponsibility());
				//권한 User => 도서관리 처리.
				if(member.getResponsibility().equals("User")) {
					bookManage();
				}else if(member.getResponsibility().equals("Admin")) {
					memberManage();
				}
			}else {
				System.out.println("아이디 또는 비밀번호가 맞지 않습니다");
			}
		}
		
		//
	}// end main
	
	
	static void bookManage() {	//도서관리
		BookDao dao = new BookDao();
		int cnt = 0;
		boolean stop = true;
		while(stop) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("1.도서등록 | 2.도서검색 | 3.도서목록 | 4.도서삭제 | 5.도서정보변경 | 6.종료");
			System.out.println("----------------------------------------------------------------");
			System.out.print("메뉴 입력 >");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1: {
				System.out.println("--도서 등록 메뉴--");
				System.out.print("책 제목 >");
				String title = sc.nextLine();
				System.out.print("글쓴이 >");
				String writer = sc.nextLine();
				System.out.print("가격 >");
				int price = Integer.parseInt(sc.nextLine());
				cnt = dao.insert(new Book(title,writer, price, 1));
				if(cnt==1) {
					System.out.println("추가 성공");
				}else {
					System.out.println("추가 실패");
				}
				
				break;
			}
			case 2: {
				System.out.println("--도서 검색 메뉴--");
				System.out.print("책 제목 >");
				String title = sc.nextLine();
				String str = dao.such(title);
				System.out.println(str);
				break;
			}
			case 3: {
				System.out.println("--도서 목록 메뉴--");
				dao.list();
				break;
			}
			case 4: {
				System.out.println("--도서 삭제 메뉴--");
				System.out.print("책 제목 >");
				String title = sc.nextLine();
				cnt = dao.delete(title);
				if(cnt == 1) {
					System.out.println("책 삭제 완료");
				}else {
					System.out.println("책 삭제 실패");
				}
				break;
			}
			case 5: {
				System.out.println("--도서 수정 메뉴--");
				System.out.print("수정할 책번호 >");
				int bnum = Integer.parseInt(sc.nextLine());
				System.out.print("책 제목 >");
				String title = sc.nextLine();
				System.out.print("글쓴이 >");
				String writer = sc.nextLine();
				System.out.print("가격 >");
				int price = Integer.parseInt(sc.nextLine());
				
				cnt = dao.update(new Book(title,writer, price, bnum));
				if(cnt == 1) {
					System.out.println("책 정보 수정 완료");
				}else {
					System.out.println("책 정부 수정 실패");
				}
				break;
			}
			case 6: {
				System.out.println("프로그램 종료");
				stop = false;
				break;
			}
			default: {
				System.out.println("값을 잘못 입력했습니다.");
				break;
			}
			}//스위치/
		}//while(stop) {
	}//bookmanage()
	
	static void memberManage() {	//회원관리
		System.out.println("관리자 메뉴 입니다.");
		System.out.println("--회원 목록--");
		int cnt = 0;
		boolean stop = true;
		while(stop) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("1.멤버등록 | 2. 멤버검색 | 3.멤버 목록 | 4.멤버삭제 | 5.멤버정보변경 | 6.종료");
			System.out.println("-------------------------------------------------------------------");
			System.out.print("메뉴 입력 >");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
				case 1: {
					
					System.out.println("---멤버 등록---");
					System.out.print("아이디 입력 >");
					String member_id = sc.nextLine();
					
					System.out.print("비밀번호 입력 >");
					String password = sc.nextLine();
					
					System.out.print("이름 입력 >");
					String member_name = sc.nextLine();
					
					System.out.print("폰번호 입력 >");
					String phone = sc.nextLine();
					
					System.out.print("권한 입력 (User | Admin) >");
					String responsibility = sc.nextLine();
					
					Member mb = new Member();
					mb.setMemberId(member_id);
					mb.setPassword(password);
					mb.setMemberName(member_name);
					mb.setPhone(phone);
					mb.setResponsibility(responsibility);
					mdao.insertmember(mb);
					break;
				}
				case 2: {
					System.out.println("---멤버 검색---");
					System.out.print("찾을 아이디 입력 >");
					String memberId = sc.nextLine();
					Member mb = mdao.suchmember(memberId);
					System.out.println(mb.toString());
					break;
				}
				case 3: {
					//멤버 리스트에 멤버 값을 집어 넣을꺼임
					//아까 메소드에서 만든거 리스트 객체 여기에 들어감
					List<Member> list = mdao.memberList();
					System.out.println("-------------------------------------------------------------");
					System.out.println("			회원목록");
					System.out.println("-------------------------------------------------------------");
					for(Member member : list) {
						System.out.println(member.toString());
					}
					break;
				}
				case 4: {
					System.out.println("---멤버 삭제---");
					System.out.print("삭제할 아이디 입력 >");
					String member_id = sc.nextLine();
					
					if(mdao.deletemember(member_id)) {
						System.out.println(member_id+"계정이 삭제 되었습니다");
					}else {
						System.out.println("삭제 실패");
					}
					
					break;
				}
				case 5: {
					System.out.println("---멤버 수정---");
					System.out.print("수정 할 아이디 입력 >");
					String member_id = sc.nextLine();
					
					System.out.print("비밀번호 수정 (0=수정안함) >");
					String password = sc.nextLine();
					
					System.out.print("이름 수정 (0=수정안함) >");
					String member_name = sc.nextLine();
					
					System.out.print("폰번호 수정 (0=수정안함) >");
					String phone = sc.nextLine();
					
					System.out.print("권한 수정 (0=수정안함) (User | Admin) >");
					String responsibility = sc.nextLine();
					
					Member mb = new Member();
					mb.setMemberId(member_id);
					mb.setPassword(password);
					mb.setMemberName(member_name);
					mb.setPhone(phone);
					mb.setResponsibility(responsibility);
					if(mdao.updatemember(mb)) {
						System.out.println(member_id+"계정이 수정 되었습니다");
					}else {
						System.out.println("수정 실패");
					}
					
					break;
				}
				case 6: {
					stop = false;
					System.out.println("프로그램 종료");
					break;
				}
				default: {
					System.out.println("값을 잘못 입력했습니다.");
					break;
				}
			}//switch (key)
		}//while(stop) {
		
		
		
		
		
	}//membermanage()
	

}// end class
