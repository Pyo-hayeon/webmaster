package test13;

public class HashSetStudent {
	public int sNo;
	public String name;
	
	public HashSetStudent(int sNo, String name) {
		this.sNo = sNo;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof HashSetStudent) {
			HashSetStudent hss = (HashSetStudent) obj;
			return (hss.sNo==sNo) && (hss.name.equals(name));
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		//return super.hashCode();
		return sNo + name.hashCode();
	}

}
