package testaccount.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
	
	static final int MAX_BALENCE = 1000000;
	static final int MIN_BALENCE = 0;
	
	List<Account> list = new ArrayList<Account>();
	
	Connection conn = null;	
	PreparedStatement pstmt = null;
	
	public void dbconnect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void dbclose() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean insetAccount(String acNo, String name, int balence) {
		dbconnect();
		//테이블 접속 테이블 유무 확인
		String sql = "select count(*) from all_tables where table_name = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "ACCOUNT");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)==0) {
					//없으면 테이블 생성
				    sql = "CREATE TABLE ACCOUNT ("
	                        + "acNo VARCHAR2(100) not null, "
	                        + "name VARCHAR2(100) not null, "
	                        + "balance NUMBER not null"
	                        + ")";
				    pstmt = conn.prepareStatement(sql);
				    pstmt.executeUpdate();
			    	//값 삽입
			    	sql = ""
						+ "insert into account (acNo, name, balance) "
						+ "values( ?, ?, ?)";
			    	pstmt = conn.prepareStatement(sql);
			    	pstmt.setString(1, acNo);
					pstmt.setString(2, name);
					pstmt.setInt(3, balence);
					int rows1 =  pstmt.executeUpdate();
					if(rows1 == 1) {
						//System.out.println("테이블 생성후 값삽입 성공");
						pstmt.close();
						rs.close();
						dbclose();
						return true;
					}else {
						//System.out.println("테이블 생성후 값삽입 실패");
						pstmt.close();
						rs.close();
						dbclose();
						return false;
					}
				}else {
					//값있는지 확인
					sql = "SELECT * FROM account WHERE acNo = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, acNo); 
					ResultSet rs1 = pstmt.executeQuery();
					if (rs1.next()) {
						//System.out.println("계좌 중복");
						rs1.close();
						pstmt.close();
						dbclose();
						return false;
					}else {
						//값 없으면 값 삽입
						sql = ""
								+ "insert into account (acNo, name, balance) "
								+ "values( ?, ?, ?)";
				    	pstmt = conn.prepareStatement(sql);
				    	pstmt.setString(1, acNo);
						pstmt.setString(2, name);
						pstmt.setInt(3, balence);
						int rows1 =  pstmt.executeUpdate();
						if(rows1 == 1) {
							//System.out.println("테이블 생성후 값삽입 성공");
							pstmt.close();
							rs.close();
							dbclose();
							return true;
						}else {
							//System.out.println("테이블 생성후 값삽입 실패");
							pstmt.close();
							rs.close();
							dbclose();
							return false;
						}
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbclose();
		return false;
	}
	public void listing() {
		dbconnect();
		String sql = "SELECT * FROM account";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			list.clear();
			while(rs.next()) {
				list.add(new Account(rs.getString(1),rs.getString(2),rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbclose();
	}
	public boolean minmax(String acNo, int balance, int i) {
		dbconnect();
		String sql = "SELECT * FROM account where acNo = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				if(i==1) {
					balance = rs.getInt(3) + balance;
				}else {
					balance = rs.getInt(3) - balance;
				}
				if(balance>MAX_BALENCE) {
					dbclose();
					return false;
				}else if(balance<MIN_BALENCE){
					dbclose();
					return false;
				}else {
					//System.out.println(balance);
					//업데이트
					sql = "" +
						"update account " +
						"set balance=? " +
						"where acNo=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, balance);
					pstmt.setString(2, acNo);
					pstmt.executeUpdate();
					dbclose();
					return true;
				}
			}else {
				System.out.println("계좌 없음");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbclose();
		return false;
	}
	public boolean delete(String acNo) {
		dbconnect();
		
		String sql = "delete from account where acNo=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acNo);
			int rows = pstmt.executeUpdate();
			if(rows==1) {
				dbclose();
				return true;
			}else {
				dbclose();
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
