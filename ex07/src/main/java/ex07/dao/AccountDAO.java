package ex07.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountDAO {
	
	public void transfer(String fromAccountId, String toAccountId, double amount) throws SQLException {
		Connection conn = null;
		PreparedStatement withdrawStmt = null;
		PreparedStatement depositStmt = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			
			// 출금 계좌에서 금액 차감
			String withdrawSql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
			withdrawStmt = conn.prepareStatement(withdrawSql);
			withdrawStmt.setDouble(1, amount);
			withdrawStmt.setString(2, fromAccountId);
			withdrawStmt.setDouble(3, amount);
			int withdrawResult = withdrawStmt.executeUpdate();	// fromAccountId 계좌에서 돈이 나감
			
			if(withdrawResult == 0) {
				System.out.println("1번 에러");
				throw new SQLException("잔액 부족 또는 계좌 없음");
			} 
			
			// 입금 계좌에 금액 추가
			String depositSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
			depositStmt = conn.prepareStatement(depositSql);
			depositStmt.setDouble(1, amount);
			depositStmt.setString(2, toAccountId);
			int depositResult = depositStmt.executeUpdate();	// toAccountId 계좌에서 돈이 들어옴
			
			if(depositResult == 0) {
				System.out.println("2번 에러");
				throw new SQLException("입금 계좌 없음");
			}
			
			//트랜잭션 커밋
			conn.commit();	
		} catch(SQLException e) {
			if(conn != null) {
				try {
					conn.rollback();	// 오류 발생 시 롤백
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			throw e;
		} finally {
			// 리소스 해제
			if(withdrawStmt != null) withdrawStmt.close();
			if(depositStmt != null) depositStmt.close();
			if(conn != null) {
				conn.setAutoCommit(true);
				conn.close();
			}
		}
	}
	
	public void transfer(Connection conn, String fromAccountId, String toAccountId, double amount) {
		
		/*
		try {
			conn = AccountDAO.getConnection();
			conn.setAutoCommit(false);
			
			int withdrawResult = withdraw(conn, fromAccountId, amount);
			if(withdrawResult == 0) throw new SQLException("잔액 부족 또는 계좌 없음");
			
			int depositResult = deposit(conn, toAccountId, amount);
			if(depositResult == 0) throw new SQLException("입금 계좌 없음");
			
			conn.commit();
		} catch(SQLException e) {
			if (conn != null) conn.rollback();
            throw e;
		} finally {
			if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
		}
		*/
	}
	
	// 계좌 출금
	public int withdraw(Connection conn, String accountId, double amount) throws SQLException {
		String query = "UPDATE accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			pstmt.setDouble(1, amount);
			pstmt.setString(2, accountId);
			pstmt.setDouble(3, amount);
			return  pstmt.executeUpdate();
		} 
	}
	
	// 계좌 입금
	public int deposit(Connection conn, String accountId, double amount) throws SQLException {
		String query = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			pstmt.setDouble(1, amount);
			pstmt.setString(2, accountId);
			return  pstmt.executeUpdate();
		} 
	}
	
	
	// 1. 접속 객체(Connection) 제공
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String uid = "green";
		String upw = "1234";
		
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			
			if(conn != null) {
				System.out.println("DB 접속 성공....");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	

	// 2. DAO 에서 사용된 자원 해제(Connection, Statement, ResultSet) 
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			close(conn, pstmt);
			System.out.println("추가로 rs 자원해제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 2-1. ResultSet을 사용하지 않는 경우
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			System.out.println("conn, stmt 자원해제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}	
