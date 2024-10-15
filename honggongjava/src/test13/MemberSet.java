package test13;

public class MemberSet {
	public String name;
	public int age;
	
	public MemberSet(String name, int age) {
		this.name = name;
		this.age = age;
	}
		
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MemberSet) {
			MemberSet ms = (MemberSet) obj;
			//내부의 존재하는 모든 값이 같으면 참 => 삽입 못함
			return (ms.name.equals(name)) && (ms.age==age);
		}else {
			//값이 다르면 삽입가능
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		//return super.hashCode();
		//객체내에 있는 실제데이터들로 해시코드를 만듬
		return name.hashCode() + age;
	}

}
