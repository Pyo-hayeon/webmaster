package chap05;

import java.util.Scanner;

public class Exam223 {

	public static void main(String[] args) {
		//6번문제
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		int max = 0;
		int total = 0;
		String str = "";
		
		while(run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");
			int num = scanner.nextInt();
			
			switch (num) {
				case 1: {
					System.out.print("학생수> ");
					studentNum = scanner.nextInt();
					scores = new int[studentNum];
					break;
				}
				case 2: {
					if(studentNum!=0) {
						for(int i=0; i<studentNum; i++) {
							System.out.print("scores["+i+"]> ");
							int score = scanner.nextInt();
							scores[i] = score;
							if(max<scores[i]) {
								max = scores[i];
							}
							total += scores[i];
							str += "scores["+i+"]> "+scores[i]+"\n";
						}
					}else {
						System.out.println("학생수 입력 후 시도해 입력해주세요");
					}
					break;
				}
				case 3: {
					if(studentNum==0 || total==0) {
						System.out.println("학생수 또는 점수를 입력 후 시도해 입력해주세요");
					}else {
						System.out.println(str);
					}
					break;
				}
				case 4: {
					if(studentNum==0 || total==0) {
						System.out.println("학생수 또는 점수를 입력 후 시도해 입력해주세요");
					}else {
						System.out.println("최고 점수: "+max);
						System.out.printf("평균 점수: %f\n",(double)total/scores.length);	
					}
//					if(studentNum!=0) {
//						if(total!=0) {
//														
//						}else {
//							System.out.println("점수를 입력해주세요");
//						}
//					}else {
//						System.out.println("학생수를 입력해주세요");
//					}
					break;
				}
				case 5: {
					run = false;
					System.out.println("프로그램 종료");
					break;
				}
				default: {
					System.out.println("값을 잘못 입력했습니다.");
					break;
				}
			}
		}

	}

}
