package testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbInsert {

	public static void main(String[] args) {
				Connection conn = null;
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe",
							"java",
							"1234"
							);
					System.out.println("연결 성공");
					
					
					//----------여기에 작업---------------
					
					//SQL문 변수 생성하여 query문 작성
					//seq_bno.nextVal 앞전 db에 seq 생성해놓은 변수 1씩 자동 증가
					String sql = ""
							+ "insert into boards (bno, btitle, bcontent, bwriter, bdate) "
							+ "values(seq_bno.nextVal, ?, ?, ?, sysdate)";
					
					//내용에 ? 가 있는 이유??
					// 보안을 위해서 직접 넣지 않고 PreparedStatement 사용해서 ? 를 체운다
					//PreparedStatement pstmt = conn.prepareStatement(sql);
					
					//삽입되는 값이 어떤것인지 칼럼을 new String[] {"bno", "btitle"} 객체로 만든다
					PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno", "btitle"});
					//물음표 1번 항복에 String 데이터 타입으로 "눈오는 밤" 을 넣는다
					pstmt.setString(1, "제목4");
					pstmt.setString(2, "내용4");
					pstmt.setString(3, "글쓴이4");
					
					//pstmt.executeUpdate(); => 처리한 쿼리 갯수를 반환한다
					int rows =  pstmt.executeUpdate();
					if(rows == 1) {
						//ResultSet 데이터 베이스 쿼리를 저장하는 객체
						//getGeneratedKeys 해당객체의 기본키값을 가져옴 
						ResultSet rs = pstmt.getGeneratedKeys();
						if(rs.next()) {
							//내가 방금 저장시킨게 어떤것인지 확인 할수 있다
							int bno = rs.getInt(1);	// 1 : 칼럼 번호
							String title = rs.getString(2);
							System.out.println("저장된 값은 : "+bno+" "+title);
						}
						rs.close(); //사용완료한 객체는 종료 시켜준다
						
						System.out.println("추가성공");
					}else {
						System.out.println("추가실패");
					}
					pstmt.close();	// 계속 객체들 종료 해줘야함
					
					
					//----------여기에 작업 끝---------------
					
					
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					if(conn != null) {
						try {
							conn.close();
							System.out.println("연결 끊기");
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}

	}

}
