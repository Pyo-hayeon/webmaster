package testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import 표하연.Account;

public class DbSelect {

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
			
			
			//----------여기에 작업---------------
			//PreparedStatement로 ? 하면 ?에는 '' 작은 따음표 안해줘도 됨
			String sql = "select * from boards where bwriter Like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "글쓴이%");
			
			//셀렉트만 executeQuery
			//인서트,딜리트,업데이트는 전부 executeUpdate
			ResultSet rs = pstmt.executeQuery();

			
			//객체배열로 DB 저장해서 사용하는법
			int plag = 0;
			while(rs.next()) {
				plag++;
			}
			Board[] bd = new Board[plag];
			
			int k = 0;
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bd[k] = new Board(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
				k++;
			}
			for(Board bb : bd) {
				System.out.println(bb.toString());
			}
			
			
			
			//컬렉션 프레임워크로 저장해서 출력하는법
			//컬렉션 리스트 생성
//			List<Board> list = new ArrayList<Board>();
			//객체 삽입
//			while(rs.next()) {
//				list.add(new Board(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5)));
//			}
			//객체 출력
//			for(Board bb : list) {
//				System.out.println(bb.toString());
//			}
			
			//객체를 만들어서 출력하는법
//			while(rs.next()) {
//				Board bd = new Board();
//				bd.setBno(rs.getInt(1));
//				bd.setBtitle(rs.getString(2));
//				bd.setBcontent(rs.getString(3));
//				bd.setBwriter(rs.getString(4));
//				bd.setBdate(rs.getDate(5));
//				
//				// bd는 보드 객체인데?? Board 클래스 toString 메소드를 오버라이딩해서 변경했음
//				System.out.println(bd);
//			}
			rs.close();
			pstmt.close();
			
			
			//----------여기에 작업 끝---------------
			
			
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
					System.out.println("연결 끊기");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
