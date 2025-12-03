package models;

import java.util.List;

public class Cart {
	private List<Toy> listToy ;
	private double totalPrice;
	public Cart(List<Toy> listToy, double totalPrice) {
		super();
		this.listToy = listToy;
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Cart [listToy=" + listToy + ", totalPrice=" + totalPrice + "]";
	}
	public List<Toy> getListToy() {
		return listToy;
	}
	public void setListToy(List<Toy> listToy) {
		this.listToy = listToy;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
