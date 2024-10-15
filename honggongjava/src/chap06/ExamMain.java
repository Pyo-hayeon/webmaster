package chap06;

import java.util.Scanner;

public class ExamMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Exam[] sd = new Exam[5];
		
		for(int i=0; i<sd.length; i++) {
			System.out.print("학번을 입력하세요 > ");
			String stNo = sc.nextLine();
			System.out.print("이름을 입력하세요 > ");
			String name = sc.nextLine();
			
			int engNum = (int)(Math.random()*51)+50;
			int korNum = (int)(Math.random()*51)+50;
			int matNum = (int)(Math.random()*51)+50;

			sd[i] = new Exam(stNo,name,engNum,korNum,matNum);
		}
		
		for(int i=0; i<sd.length; i++) {
			System.out.printf("학번:%s 이름:%s 영어:%d 국어:%s 수학:%s 총점:%s 평균:%.2f 등급:%s\n", sd[i].stNo,sd[i].name, sd[i].engNum, sd[i].korNum, sd[i].matNum, sd[i].sum(), sd[i].avg(), sd[i].grade());
		}
	}
}
