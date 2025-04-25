package test_discount_store.VO;

import lombok.Data;

@Data
public class ProductListDto {
	private String pcode;
	private String pname;
	private int cost;
	private int discount10;
	private int discount15;
}
