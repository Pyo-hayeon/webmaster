package chap06;

public class StudentExamMain {

	public static void main(String[] args) {
		//5명의 사람과 학번 불러와서 점수의 합계와 평균 등급을 나오게 하라
		
		
		//배열 값을 이용해서 해도됨
//		StudentExam[] students = {
//				new StudentExam("","홍길동",30,30,30),
//				new StudentExam("","홍길동",30,30,30),
//				new StudentExam("","홍길동",30,30,30),
//				new StudentExam("","홍길동",30,30,30)
//		};
		
		
		//이렇게 해도됨
		String[] stNo = {"20240805","20240704","20240603","20240502","20240401"};
		String[] name = {"표하연","고영희","김철수","홍길도","성춘향"};
		for(int i=0; i<5; i++) {
			int koNum = (int)(Math.random()*51)+50;
			int engNum = (int)(Math.random()*51)+50;
			int matNum = (int)(Math.random()*51)+50;
			StudentExam student = new StudentExam(stNo[i],name[i],koNum,engNum,matNum);
			
			System.out.printf("%s : %s : %d : %.2f : %s\n",stNo[i],name[i],student.sum(),student.avg(),student.grade());
		}
		
	}

}
