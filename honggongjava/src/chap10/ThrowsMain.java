package chap10;

public class ThrowsMain {

	public static void main(String[] args){
		
		//public static void main(String[] args) throws ClassNotFoundException 이런식으로 클래스에 명시해서 오류 받아도되나
		//메인까지 예외를 던지면 왠만하면 트라이 캐치로 해당 부분에서 받는게 좋음
		//findClass();
		
		//예외 떠넘기기
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("class 찾지 못함");
		}
	}

	//호출하는곳에 예외처리를 떠 넘김
	private static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String2");
	}

}
