package testdb.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbDao {
	//메소드에 사용되기때문에 전역변수로 빼놓는다
		Connection conn = null;
		
		//데이터 베이스 연결 메소드
		public void getOpenDb() {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"java",
						"1234"
						);
				System.out.println("연결성공");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//getOpenDb()
		
		//데이터 베이스 종료 메소드
		public void getCloseDb() {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결끊기");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//getCloseDb()
}
