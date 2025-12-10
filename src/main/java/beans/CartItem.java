package beans;

public class CartItem {
	private int id;
	private int cartID;
	private int pid;
	private int quantity;
	private double price; // giá tại thời điểm thêm vào giỏ

	private Product product; // để hiển thị tên, ảnh

	// constructor
	public CartItem() {
	}

	public CartItem(int id, int cartID, int pid, int quantity, double price) {
		this.id = id;
		this.cartID = cartID;
		this.pid = pid;
		this.quantity = quantity;
		this.price = price;
	}

	// getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getTotal() {
		return quantity * price;
	}
}