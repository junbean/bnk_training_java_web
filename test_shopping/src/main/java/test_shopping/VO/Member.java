package test_shopping.VO;

import java.sql.Date;

import lombok.Data;

@Data
public class Member {
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private String joindate;
	private String grade;
	private String city;
}
