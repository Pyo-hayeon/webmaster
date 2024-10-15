package testaccount.arraylist;

public class AccountArrayList {
	//필드
		//계좌번호 계좌주 금액
		private String acNo;
		private String name;
		private int balence;
		
		
		public AccountArrayList() {}
		
		public AccountArrayList(String acNo,	String name, int balence) {
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
		
		//리스트 맵에 객체 삭제 하기 위해서 필요한 메소드
		@Override
	    public boolean equals(Object obj) {
			if(obj instanceof AccountArrayList) {
				AccountArrayList al = (AccountArrayList) obj;
				
				return al.acNo.equals(acNo) &&
						al.name.equals(name) &&
						al.balence == balence;
			}else {
				return false;
			}
	    }
		//리스트 맵에 객체 삭제 하기 위해서 필요한 메소드
	    @Override
	    public int hashCode() {
	        return acNo.hashCode()+name.hashCode()+balence; // 필드 기반 hash 생성
	    }
		
}
