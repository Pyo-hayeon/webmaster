package test13;

public class HashMapStudent {
	public int sno;
	public String name;
	public int score;
	
	public HashMapStudent(int sno, String name, int score) {
		this.sno = sno;
		this.name = name;
		this.score = score;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof HashMapStudent) {
			HashMapStudent hms = (HashMapStudent) obj;
			return (hms.sno==sno) && (hms.score==score) && (hms.name.equals(name));
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		//return super.hashCode();
		return sno + name.hashCode() + score;
	}

}
