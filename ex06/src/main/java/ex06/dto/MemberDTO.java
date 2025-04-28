package ex06.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
// 이걸 안하면 에러가 발생
// final 지정하면 값이 있어야 하기 때문에 AllArgs가 있어야 함
// 그래서 final 에 생성될때 값을 지정하게 함
@AllArgsConstructor	
@ToString
public class MemberDTO {
	private final String id;
	private final String pw;
	private final String name;
	private final String phone;
	private String grade;
}
/*

DTO란?
	서비스에서 DAO에서 controller 에서 계층간에 데이터를 전송하는 객체이다
	final 을 사용하는 것은 계층간 데이터를 이동할때 어떠한 데이터가 변경되지 않기위해서 사용한다



*/