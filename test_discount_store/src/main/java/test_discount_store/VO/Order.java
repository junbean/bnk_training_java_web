package test_discount_store.VO;

import lombok.Data;

@Data
public class Order {
	private String orderno;
	private String shopno;
	private String orderdate;
	private String pcode;
	private int amount;
}
