package beans;

public class Account {
	private int uid;
	private String user, pass, fullName, email, phone;
	private boolean isAdmin;

	public Account() {
	}

	public Account(int uid, String user, String pass, String fullName, String email, String phone, boolean isAdmin) {
		this.uid = uid;
		this.user = user;
		this.pass = pass;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.isAdmin = isAdmin;
	}

	// Getters & Setters (tự sinh hoặc copy)
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}