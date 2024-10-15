package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertMain {

	public static void main(String[] args) {
		//데이터 추가
		Connection conn = null;
		try {
			//jdbc드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 url / id / pw
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결성공");
			
			//여기에 데이터 추가 작업은 여기에 하기
			//seq_bno.nextVal 시퀀스 자동증가 문장
			//sysdate 현재 날짜 
			// 괄호 뒤에는 띄워쓰기 하도록 dbate) "
			String sql = ""
					+ "insert into boards (bno, btitle, bcontent, bwriter, bdate) "
					+ "values(seq_bno.nextVal, ?, ?, ?, sysdate)";
			
			//String sql 에 값 넣는거
			//PreparedStatement 보안을 위해 sql문을 미리 컴파일 하고
			//해당 ? 로 표시된 내용들에 순서를 메겨서 값을 넣는것임
			//PreparedStatement pstmt = conn.prepareStatement(sql);
			//뒤에 배열을 만들어서 처리하면
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno", "btitle", "bwriter"});
			//첫번쨰 물음표에 값을 넣는것 ( setString = 문자열 이여서 String )
			pstmt.setString(1, "눈오는 밤");
			pstmt.setString(2, "눈이 펑펑 내려요...");
			pstmt.setString(3, "스노우");
		
			//sql 쿼리 업데이트 치기
			int rows =  pstmt.executeUpdate();
			if(rows == 1) {
				//ResultSet 데이터 베이스 쿼리를 저장하는 객체
				//getGeneratedKeys 해당객체의 기본키값을 가져옴 
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					//내가 방금 저장시킨게 어떤것인지 확인 할수 있다
					int bno = rs.getInt(1);	// 1 : 칼럼 번호
					String title = rs.getString(2);
					String writer = rs.getString(3);
					System.out.println("저장된 번호 : "+bno+title+writer);
				}
				System.out.println("추가 성공");
				rs.close(); // 계속 객체들 종료 해줘야함
			}else {
				System.out.println("추가 실패");
			}
			pstmt.close();	// 계속 객체들 종료 해줘야함
			
			
			
			
			
			
			
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
