package 표하연;

public class Account {
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	
	private String ano;
	private String owner;
	private int balence;
	
	//생성자
	Account(String ano, String owner, int balence){
		this.ano = ano;
		this.owner = owner;
		this.balence = balence;
	}
	
	//메소드
	void anoSetter(String ano){
		this.ano = ano;
		System.out.println("aaaa");
	}
	void ownerSetter(String owner){
		this.owner = owner;
	}
	void balenceSetter(int balence){
		this.balence = balence;
	}
	
	
	String anoGetter() {
		return ano;
	}

	String ownerGetter() {
		return owner;
	}
	int balenceGetter() {
		return balence;
	}
	
	
	boolean setBalence(int balence) {
		if(balence > MAX_BALANCE) {
			return false;
		}else if(balence < MIN_BALANCE) {
			return false;
		}else {
			this.balence = balence;
			return true;
		}
	}
	

}
