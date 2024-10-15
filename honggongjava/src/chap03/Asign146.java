package chap03;

public class Asign146 {

	public static void main(String[] args) {
		int result = 0;
		result += 10;
		System.out.println(result);
		result -= 5;
		System.out.println(result);
		result *= 3;
		System.out.println(result);
		result /= 5;
		System.out.println(result);
		result %= 3;
		System.out.println(result);


		int su = 1;
		int su2 = 2;
		// 1은 true 0은 false
		//2진수 계산  1 => 01 / 2 => 10 / 앞자리 0 뒷자리 0 / 십진수로 변경 결과 0
		// 2/2 이면 2 => 10 / 1 0 / 1 0 / 앞자리 1 뒷자리 0 / 십진수로 변경 결과 2
		System.out.println(su & su2);
		System.out.println(su | su2); // 3
		System.out.println(su ^ su2); // 3

	}

}
