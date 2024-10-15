package chap01;

import java.io.IOException;

public class System117 {

	public static void main(String[] args) {
		int keyCode;
		
		while(true) {
			//예외 처리
			try {
				keyCode = System.in.read();
				System.out.print("키 입력 : ");					
				System.out.println("keyCode: "+ keyCode);
				if(keyCode==113) {
					break;
				}
			} catch (IOException e) {
				System.out.println("입력 오류 발생");
			}//while(true) {
		}//while(true) {
	}//main(String[] args) {
}//System117 {