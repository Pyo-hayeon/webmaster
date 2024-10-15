package chap06;

public class StudentExam {
	//객체
	String stNo;
	String name;
	int koNum;
	int engNum;
	int matNum;
	
	//생성자
	StudentExam(String stNo, String name, int koNum, int engNum, int matNum){
		this.stNo = stNo;
		this.name = name;
		this.koNum = koNum;
		this.engNum = engNum;
		this.matNum = matNum;
	}
	//메소드
	int sum() {
		return koNum+engNum+matNum;
	}
	
	double avg() {
		return sum()/3.0;
	}
	
	String grade() {
		int b = (int)avg()/10;
		String result = "";
		switch (b) {
			case 10,9:{
				result = "A";
				break;
			}
			case 8:{
				result = "B";
				break;
			}
			case 7:{
				result = "C";
				break;
			}
			case 6:{
				result = "D";
				break;
			}
			default:{
				result = "F";
				break;
			}
		}
		return result;
	}
	
}
