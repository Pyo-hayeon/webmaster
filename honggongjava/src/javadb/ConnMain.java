package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnMain {

	public static void main(String[] args) {
		// 데이터 베이스 연결
		// jdbc 등록
		// 이거 계속 쓰니까 복붙으로 계속 쓰기
		Connection conn = null;	//임포트 해야 사용 가능
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//DB 연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결 성공");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//연결 되었다면
			if(conn != null) {
				try {
					//연결 끈기
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		

	}

}
