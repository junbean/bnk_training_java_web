package ex07.service;

import java.sql.Connection;
import java.sql.SQLException;

import ex07.dao.AccountDAO;

public class AccountService {
	private AccountDAO accountDAO = new AccountDAO();
	
	public void transfer(String fromAccountId, String toAccountId, double amount) throws SQLException {
		Connection conn = null;
		
		try {
			conn = AccountDAO.getConnection();
			conn.setAutoCommit(false);
			
			int withdrawResult = accountDAO.withdraw(conn, fromAccountId, amount);
			if(withdrawResult == 0) throw new SQLException("잔액 부족 또는 계좌 없음");
			
			int depositResult = accountDAO.deposit(conn, toAccountId, amount);
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

		/*
		try {
			conn = AccountDAO.getConnection();
			conn.setAutoCommit(false);
			
			int withdrawResult = accountDAO.withdraw(conn, fromAccountId, amount);
			if(withdrawResult == 0) throw new SQLException("잔액 부족 또는 계좌 없음");
			
			int depositResult = accountDAO.deposit(conn, toAccountId, amount);
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
}
