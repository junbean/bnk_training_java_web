package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBTest {

	public static void main(String[] args) {

		Connection conn = DBCon.getConnection();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_member");
			
			while(rs.next()) {
				Member member = new Member();
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String grade_temp = rs.getString("grade");
				char grade = grade_temp.charAt(0);
				
				/*
				member.setId(id);
				member.setPw(pw);
				member.setName(name);
				member.setPhone(phone);
				member.setGrade(grade);
				*/
				
				System.out.println(id + "\t" + pw + "\t" + name + "\t" + phone + "\t" + grade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

/*
String query = "SELECT * FROM tbl_member";
PreparedStatement pstmt = conn.prepareStatement(query);
ResultSet rs = pstmt.executeQuery();
*/
