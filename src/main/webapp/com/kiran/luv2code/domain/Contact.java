package main.webapp.com.kiran.luv2code.domain;

public class Contact {
	
	private Integer user_contact_id;
	private Integer user_id; 
	private String  name ;  
	private String  phone ; 
	private String  email ; 
	private String  address ;
	private String  remark ;
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}
	
	public Contact(Integer user_id, String name,
			String phone, String email, String address, String remark) {
		this.user_id = user_id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.remark = remark;
	}



	public Integer getUser_contact_id() {
		return user_contact_id;
	}
	public void setUser_contact_id(Integer user_contact_id) {
		this.user_contact_id = user_contact_id;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Contact [user_contact_id=" + user_contact_id + ", user_id="
				+ user_id + ", name=" + name + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", remark=" + remark + "]";
	}
}
