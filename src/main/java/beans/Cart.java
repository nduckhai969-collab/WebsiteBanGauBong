package beans;

import java.util.Date;

public class Cart {
	private int cartID;
	private int uid;
	private Date buyDate;
	private int status; // 0 = đang trong giỏ, 1 = đã thanh toán

	public Cart() {
	}

	public Cart(int cartID, int uid, Date buyDate, int status) {
		this.cartID = cartID;
		this.uid = uid;
		this.buyDate = buyDate;
		this.status = status;
	}

	// getters & setters
	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}