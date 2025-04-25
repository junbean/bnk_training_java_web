package test_discount_store.VO;

import lombok.Data;

@Data
public class ShopOrderListDto {
	private String shopno;
	private String pcode;
	private String pname;
	private int totalAmount;
}
