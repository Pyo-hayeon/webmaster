package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateMain {

	public static void main(String[] args) {
		//연결하기
		Connection conn = null;
		
		try {
			//jdbc 등록 및 트라이캐치 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//연결 등록 및 캐치 등록
			conn = DriverManager.getConnection(
					"jdbc:Oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			//연결성공 텍스트 입력 및 finally 작업
			System.out.println("연결성공");
			
			
			//데이터 수정
			String sql = "" +
					"update boards " +
					"set btitle=?, bcontent=? " +
					"where bno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "화장실"); // 첫번째 물음표에 값을 넣음
			pstmt.setString(2, "지금 너무 가고 싶어요 ㅠ");
			pstmt.setInt(3, 4);
			
			//여기까지 sql 문장 모두 완성
			
			//sql 처리하고 결과 값을 변수에 저장
			//몇개 성공했어 라는걸 반환해줌
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 갯수 : " + rows);
			
			
			System.out.println();
			//업데이트문은 결과값을 반환하지 않기때문에 select 문으로 확인 해야함
			sql = "select * from boards";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, 4);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.printf("수정된 값 : %d %s %s\n",rs.getInt("bno"),rs.getString("btitle"),rs.getString("bcontent"));
			}
	
			System.out.println();

			
			rs.close();
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
					//DB 연결 끊음
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
