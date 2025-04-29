package ex06.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBconnPool {
	
	Connection conn;
	
	public DBconnPool() {
		try {
			// 자원 리소스를 관리하기 위한 객체
			Context initCtx = new InitialContext();
			Context ctx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)ctx.lookup("dbcp_myoracle");
		
			conn = ds.getConnection();
			
			if(conn != null) {
				System.out.println("DB 커넥션 풀 연결 성공");
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
}
