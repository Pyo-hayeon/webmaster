package testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDelete {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결성공");
			
			
			
			//데이터 삭제
			String sql = "delete from boards where bno in (?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 3);
			int rows = pstmt.executeUpdate();
			System.out.println("삭제행 수 : "+rows);
			pstmt.close();
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결끊기");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
