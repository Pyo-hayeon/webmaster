package testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
		//db 연결시 상태 값 받을 변수
		Connection conn = null;	//임포트 해야 사용 가능
		try {
			//아까 jar파일 임포트 한거 에서 해당 패키지 내에 있는 OracleDriver를 메모리에 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//DB 연결
			//jdbc:oracle:thin: => TCP용 JDBC 드라이버 사용한다
			//홈페이지 주소는 localhost
			//포트번호는 1521
			//SID명은 xe
			//아까만든 java 계정이고 비밀번호는 1234 이다
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결 성공");
			
			
			
			/*
			 * 모든 DB작업은 여기 안에서 처리함!!
			 */
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//연결 잘 연결되었다면
			// 해당 구분이 실행되는 경우는 작업처리 영역에서 작업이 완료되었단뜻
			if(conn != null) {
				try {
					//연결 끈기
					// 메모리 효율관리를 위해서 사용끝난 DB는 종료 처리
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
