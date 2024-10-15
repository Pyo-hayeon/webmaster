package testaccount.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AccountHashSetDao {
	
	static final int MAX_BALENCE = 1000000;
	static final int MIN_BALENCE = 0;
	
	Set<AccountHashSet> set = new HashSet<AccountHashSet>();

	boolean tf = false;
	public boolean insetAccount(String acNo, String name, int balence) {
		if(set.isEmpty()) {
			set.add(new AccountHashSet(acNo, name, balence));
			return true;
		}else {
			Iterator<AccountHashSet> iterator = set.iterator();
			while(iterator.hasNext()) {
				AccountHashSet ahs = iterator.next();
				if(ahs.getAcNo().equals(acNo)) {
					tf = true;
					break;
				}else {
					tf = false;
				}
			}//while(iterator.hasNext())
			
			if(!tf) {
				set.add(new AccountHashSet(acNo, name, balence));
				return true;
			}
		}
		return false;
	}
	public boolean minmax(String acNo, int balence, int menu) {
		
		Iterator<AccountHashSet> iterator = set.iterator();
		String acNo1 = null;
		String name1 = null;
		int balence1 = 0;
		while(iterator.hasNext()) {
			AccountHashSet ahs = iterator.next();
			if(ahs.getAcNo().equals(acNo)) {
				if(menu==1) {
					balence1 = ahs.getBalence() + balence;
					balence = ahs.getBalence();
				}else {
					balence1 = ahs.getBalence() - balence;
					balence = ahs.getBalence();
				}
				acNo1 = ahs.getAcNo();
				name1 = ahs.getName();
			}
		}
		if(acNo1!=null) {
			if(balence1>MAX_BALENCE) {
				return false;
			}else if(balence1<MIN_BALENCE){
				return false;
			}else {
				//기존값 객체삭제
				if(set.remove(new AccountHashSet(acNo, name1, balence))) {
					//신규 객체 추가
					set.add(new AccountHashSet(acNo1, name1, balence1));
					return true;					
				}else {
					return false;
				}
			}
		}else {
			return false;
		}
	}
	public boolean delete(String acNo) {
		Iterator<AccountHashSet> iterator = set.iterator();
		String acNo1 = null;
		String name1 = null;
		int balence1 = 0;
		while(iterator.hasNext()) {
			AccountHashSet ahs = iterator.next();
			if(ahs.getAcNo().equals(acNo)) {
				acNo1 = ahs.getAcNo();
				name1 = ahs.getName();
				balence1 = ahs.getBalence();
				break;
			}
		}
		
		if(acNo1!=null) {
			set.remove(new AccountHashSet(acNo1, name1, balence1));
			return true;
		}else {
			return false;
		}
	}

}
