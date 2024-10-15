package chap07.pack2;
import chap07.pack1.A;
public class D extends A{
	//다른 패키지에서 상속받아서 사용가능
	public D() {
		super();
		this.field = "aadsf";
		this.mothod();
	}
	
	public void mothod() {
		this.field = "aadsf";
		this.mothod();
	}
}
