package chap01;

public class Escape88 {
	// static = 클래스에 객체없이 쓸수있는 클래스다
	// void = 리턴 값이 없다
	public static void main(String[] args) {
		System.out.println("번호\t이름\t직업");
		System.out.print("행 단위 출력\n");
		System.out.print("행 단위 출력\n");
		System.out.println("우리는 \"개발자\" 입니다.");
		System.out.print("봄\\여름\\가을\\겨울");
		
		//91페이지
		boolean stop = false;
		//stop = true;
		if(!stop) {
			System.out.println("중지합니다");
		}else {
			System.out.println("시작합니다");
		}
		
		//103페이지
		//타입 변환
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		int intValue1 = byteValue1 + byteValue2;
		System.out.println(intValue1);
		
		char charValue1 = 'A';
		char charValue2 = 1;
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드="+intValue2);
		System.out.println("출력문자="+(char)intValue2);
		
		int intValue3 = 10;
		int intValue4 = intValue3/4;
		System.out.println(intValue4);
		
		int intValue5 = 10;
		double doubleValue = intValue5/4.0;
		System.out.println(doubleValue);
		
		int x = 1;
		int y = 2;
		double result = (double)x/y;
		System.out.println(result);
		
		//106페이지
		//문자열->숫자, 숫자->문자열 변환
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println("value1: " + (value1+100));
		System.out.println("value2: " + (value2+100));
		System.out.println("value3: " + value3);
		
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.14);
		String str3 = String.valueOf(true);
		
		System.out.println("str1: "+ (Integer.parseInt(str1)+100));
		System.out.println("str2: "+ (Double.parseDouble(str2)+100));
		System.out.println("str3: "+ str3);
		
		//109페이지 확인문제5 b출력
		char c1 = 'a';
		char c2 = (char) (c1+1);
		System.out.println(c2);
		int c3 = c2;
		System.out.println(c3);
		//문제 6번,7번
		int xx = 5;
		int yy = 2;
		double resul1 = (double)xx/yy;
		System.out.println(resul1);
		//문제 8번
		double varr1 = 3.5;
		double varr2 = 2.7;
		int result2 = (int)(varr1+varr2);
		System.out.println(result2);
		//문제 9번
		long var1 = 2L;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		int result3 = (int) ((double)var1+(double)var2+(int)var3+Double.parseDouble(var4));
		System.out.println(result3);
		//문제 10번
		String str11 = 2+3+""; // 앞에서 부터 계산되기에 정수(2+3) 문자 ""= 5가나옴
		String str12 = 2+""+3;
		String str13 = ""+2+3;
		System.out.println(str11);
		System.out.println(str12);
		System.out.println(str13);
		//문제 11번
		byte value21 = Byte.parseByte("10");
		int value22 = Integer.parseInt("1000");
		float value23 = Float.parseFloat("20.5");
		double value24 = Double.parseDouble("3.14159");
		System.out.println(value21);
		System.out.println(value22);
		System.out.println(value23);
		System.out.println(value24);
		
		
		
	}//end main
}//end class
