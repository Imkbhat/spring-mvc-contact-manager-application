package main.webapp.com.kiran.luv2code.domain;

public class User {
	
	private Integer user_id; 
	 private String name; 
	 private String phone; 
	 private String email; 
	 private String address; 
	 private String login_name; 
	 private String password; 
	 private Integer role ; 
	 private Integer login_status;
	 
	 public User() {

	 }
	 
	public User(String name, String phone, String email, String address,
			String login_name, String password, Integer role,
			Integer login_status) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.login_name = login_name;
		this.password = password;
		this.role = role;
		this.login_status = login_status;
	}

	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getLogin_status() {
		return login_status;
	}
	public void setLogin_status(Integer login_status) {
		this.login_status = login_status;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", phone="
				+ phone + ", email=" + email + ", address=" + address
				+ ", login_name=" + login_name + ", password=" + password
				+ ", role=" + role + ", login_status=" + login_status + "]";
	}
	
}
