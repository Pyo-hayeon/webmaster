package testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUpdate {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:Oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결성공");
			
			
			// ------------여기서부터 작업----------
			//데이터 수정
			String sql = "" +
					"update boards " +
					"set btitle=?, bcontent=? " +
					"where bno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "화장실"); // 첫번째 물음표에 값을 넣음
			pstmt.setString(2, "지금 너무 가고 싶어요 ㅠ");
			pstmt.setInt(3, 4);
			
			int rows = pstmt.executeUpdate();
			if(rows==1) {
				System.out.println("수정 완료");
				System.out.println("수정된 갯수 : " + rows);
				
				System.out.println();
				sql = "select * from boards where bno=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, 4);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.printf("수정된 값 : %d %s %s\n",rs.getInt("bno"),rs.getString("btitle"),rs.getString("bcontent"));
				}
				rs.close();
			}else {
				System.out.println("수정 실패");
			}
			
			pstmt.close();
			
			// ------------여기서부터 작업끝----------
			
			
			
			
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
