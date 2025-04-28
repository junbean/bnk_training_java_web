package ex06.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex06.dto.MemberDTO;

public class DBUtilTest {

	public static void main(String[] args) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberDTO> list = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM tbl_member");
			rs = pstmt.executeQuery();

			/*
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String grade = rs.getString("grade");

				MemberDTO member = new MemberDTO(id, pw, name, phone, grade);

				list.add(member);
			}
			*/
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		// 자원 해제
		DBUtil.close(conn, pstmt, rs);

		/*
		for (int i = 0; i < list.size(); i++) {
			System.out.println(
					list.get(i).getId() + " \t"
					+ list.get(i).getPw() + "\t" 
					+ list.get(i).getName() + "\t"
					+ list.get(i).getPhone() + "\t" 
					+ list.get(i).getGrade());
		}
		*/
		
	}

}
