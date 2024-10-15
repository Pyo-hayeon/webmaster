package chap07;

public class ParentSom extends Parent{
	
	private String name;
	
	public ParentSom() {
		this("홍길동");
		System.out.println("Som() Call");
	}
	public ParentSom(String name) {
		this.name = name;
		System.out.println("Som(String nation) call");
	}
}
