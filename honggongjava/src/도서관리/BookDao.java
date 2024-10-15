package 도서관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao extends DAO{
	List<Book> list = null;
	
	
	
	//데이터 추가
	public int insert(Book book) {
		getOpen();
		String sql = ""
				    +"insert into book (title, writer, price, bnum) "
					+"values(?,?,?,seq_bnum.nextVal)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setInt(3, book.getPrice());
			int rows =  pstmt.executeUpdate();
			pstmt.close();
			getClose();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int delete(String title) {
		getOpen();
		String sql = "delete from book where title=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			int rows = pstmt.executeUpdate();
			pstmt.close();
			getClose();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int update(Book book) {
		getOpen();
		String sql = "" +
				"update book " +
				"set title=?, writer=? , price=?" +
				"where bnum=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setInt(3, book.getPrice());
			pstmt.setInt(4, book.getBnum());
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	//데이터 검색
	public String such(String title) {
		getOpen();
		String sql = "select * from book where title=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				return "책제목 : "+rs.getString(1) +"\t글쓴이 : "+rs.getString(2) +"\t가격 : "+ rs.getInt(3) +"\t책번호 : "+ rs.getInt(4); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getClose();
		return "NO";
	}
	
	public void list() {
		getOpen();
		String sql = "select * from book";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//list = new ArrayList<Book>();
			while(rs.next()) {
				//list.add(new Book(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
				System.out.println("책제목 : "+rs.getString(1) +"\t글쓴이 : "+rs.getString(2) +"\t가격 : "+ rs.getInt(3) +"\t책번호 : "+ rs.getInt(4));
			}
			
			getClose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
