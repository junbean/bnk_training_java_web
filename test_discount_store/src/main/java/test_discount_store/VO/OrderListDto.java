package test_discount_store.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderListDto {
    private String shopNo;       // 할인점코드
    private String shopName;     // 점포명
    private String orderNo;      // 주문번호
    private String orderDate;    // 주문일자
    private String pCode;        // 제품코드
    private String pName;        // 제품명
    private int amount;          // 주문수량
    private int cost;            // 단가
    private int consumerPrice;   // 소비자가격 (단가 × 주문수량)
    private int discountPrice;   // 할인가격
	public String getShopNo() {
		return shopNo;
	}
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getPCode() {
		return pCode;
	}
	public void setPCode(String pCode) {
		this.pCode = pCode;
	}
	public String getPName() {
		return pName;
	}
	public void setPName(String pName) {
		this.pName = pName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getConsumerPrice() {
		return consumerPrice;
	}
	public void setConsumerPrice(int consumerPrice) {
		this.consumerPrice = consumerPrice;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
    
    
}