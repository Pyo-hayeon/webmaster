package chap07;

public class MyParentMain {

	public static void main(String[] args) {
		MyParentSom mps = new MyParentSom();
		
		MyParent mp = mps;
		mp.method1();
		mp.mothod2();
		//부모메소드로 타입변환해서 오버라이딩 안된 자식 메소드 사용불가
		//mp.mothod3();
		
		//근데 왜 쓰는지 이유를 모르겠슴
		mps.method1();
		mps.mothod2();	//필요에의해 supuer.mothod2() 하면 되는걸
		mps.mothod3();
	}

}
