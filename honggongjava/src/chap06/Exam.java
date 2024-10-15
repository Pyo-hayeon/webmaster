package chap06;

public class Exam {
	//필드
	String stNo;
	String name;
	int engNum;
	int korNum;
	int matNum;
	
	//생성자
	Exam(String a, String b, int c, int d, int e){
		stNo = a;
		name = b;
		engNum = c;
		korNum = d;
		matNum = e;
	}
	
	//메소드
	int sum(){
		return engNum+korNum+matNum;
	}
	double avg() {
		return sum()/3.0;
	}
	
	String grade() {
		int result = (int)avg()/10;
		switch (result) {
		case 10,9: return "A"; 
		case 8: return "B";
		case 7: return "C";
		case 6: return "D";
		default: return "F";
		}
	}
}
