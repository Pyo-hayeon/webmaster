package testaccount.arraylist;

import java.util.ArrayList;
import java.util.List;

public class AccountArrayDao {
	
	static final int MAX_BALENCE = 1000000;
	static final int MIN_BALENCE = 0;
	
	List<AccountArrayList> list = new ArrayList<AccountArrayList>();
	
	public boolean insetAccount(String acNo, String name, int balence) {
		if(list.isEmpty()) {
			list.add(new AccountArrayList(acNo, name, balence));
			return true;
		}else {
			boolean tf = false;
			for(AccountArrayList ac : list) {
				if(ac.getAcNo().equals(acNo)) {
					tf = false;
					break;
				}else {
					tf = true;		
				}
			}
			if(tf) {
				list.add(new AccountArrayList(acNo, name, balence));
				return true;
			}else {
				System.out.println("중복 계좌가 있습니다");
				return false;
			}
		}
	}
	
	public boolean minmax(String acNo, int balence, int menu) {
		//계좌로 기존 금액 조회
		int originbalence = 0;
		for(AccountArrayList ac : list) {
			if(ac.getAcNo().equals(acNo)) {
				
				originbalence = ac.getBalence();
				
				if(menu==1) {
					balence = originbalence + balence;
				}else {
					balence = originbalence - balence;
				}
				
				if(balence>MAX_BALENCE) {
					return false;
				}else if(balence<MIN_BALENCE){
					return false;
				}else {
					ac.setBalence(balence);
					return true;
				}
				
			}
		}
		if(originbalence == 0) {
			System.out.println("계좌가 없습니다");
			return false;
		}
		return false;
	}
	
	public boolean delete(String acNo) {
		String acNo1 = null;
		String name1 = null;
		int balence1 = 0;
		for(AccountArrayList ac : list) {
			if(ac.getAcNo().equals(acNo)) {
				acNo1 = ac.getAcNo();
				name1 = ac.getName();
				balence1 = ac.getBalence();
			}
		}
		
		if(acNo1 == null) {
			System.out.println("계좌 번호가 없습니다.");
			return false;
		}else {
			list.remove(new AccountArrayList(acNo1, name1, balence1));
			return true;
		}
		
	}
}
