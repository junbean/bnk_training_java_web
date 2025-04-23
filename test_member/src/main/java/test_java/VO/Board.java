package test_java.VO;

import java.sql.Date;
import lombok.Data;

@Data
public class Board {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
}
