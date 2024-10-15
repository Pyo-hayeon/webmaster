package chap05;

public class Exam195 {

	public static void main(String[] args) {
		//참조타입의 번지비교(==)
		// 데이터(문자열) 비교 (equals)
		 String str1 = "표하연";
		 String str2 = "표하연";
		 String str3 = new String("표하연");
		 String str4 = new String("표하연");
		 
		 if(str1==str2) {
			 System.out.println("str1 와 str2는 참조 주소가 같음");
		 }else {
			 System.out.println("str1 와 str2는 참조 주소가 다름");
		 }
		 
		 if(str1.equals(str2)) {
			 System.out.println("str1 와 str2는 데이터 값이 같음");
		 }else {
			 System.out.println("str1 와 str2는 데이터 값이 다름");
		 }
		 
		 if(str3==str4) {
			 System.out.println("str3 와 str4는 참조 주소가 같음");
		 }else {
			 System.out.println("str3 와 str4는 참조 주소가 다름");
		 }
		 
		 if(str3.equals(str4)) {
			 System.out.println("str3 와 str4는 데이터 값이 같음");
		 }else {
			 System.out.println("str3 와 str4는 데이터 값이 다름");
		 }
		 
		

	}

}
