package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMain {

	public static void main(String[] args) {
		// 연결
		Connection conn = null;
		
		try {
			//dbms에서 지원해주는 오라클 드라이버를 가져오는거
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결성공");
			
			//데이터 삭제
			String sql = "delete from boards where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 4);
			
			int rows = pstmt.executeUpdate();
			System.out.println("삭제행 수 : "+rows);
			
			pstmt.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결끊기");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

	}

}
