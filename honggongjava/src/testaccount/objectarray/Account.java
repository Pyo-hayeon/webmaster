package testaccount.objectarray;

public class Account {
	//필드
	//계좌번호 계좌주 금액
	private String acNo;
	private String name;
	private int balence;
	
	static final int MAX_BALENCE = 1000000;
	static final int MIN_BALENCE = 0;
	
	public Account() {}
	
	public Account(String acNo,	String name, int balence) {
		this.acNo = acNo;
		this.name = name;
		this.balence = balence;
	}

	public String getAcNo() {
		return acNo;
	}

	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalence() {
		return balence;
	}

	public void setBalence(int balence) {
		this.balence = balence;
	}
	
	@Override
	public String toString() {
		return "계좌번호 : "+acNo+"\t계좌주 : "+name+"\t금액 : "+balence;
		//return super.toString();
	}
	
	public boolean MaxNin(int balence) {
		if(balence > MAX_BALENCE) {
			return false;
		}else if(balence < MIN_BALENCE){
			return false;
		}else {
			this.balence = balence;
			return true;
		}
	}

}
