package test_rsp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor	
@NoArgsConstructor
@ToString
public class Score {
	private int scoreId;
	private String memberId;
	private String win;
	private String lose;
	private String draw;
}
