package models;

public class Toy {
	private int idToy;
	private String des;
	private double price;
	public Toy(int idToy, String des, double price) {
		super();
		this.idToy = idToy;
		this.des = des;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Toy [idToy=" + idToy + ", des=" + des + ", price=" + price + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public int getIdToy() {
		return idToy;
	}
	public void setIdToy(int idToy) {
		this.idToy = idToy;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
