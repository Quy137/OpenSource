package model;

import java.util.Date;

public class Customer {
	public static final String GENDER_MALE="M";
	public static final String GENDER_FEMALE="M";
	private String customerID;
	private String userName;
	private String password;
	private String resetPassword;
	private String name;
	private String address;
	private int phoneNumber;
	private String email;
	private Date dob;
	private String gender;
	private Date joinDate;
	
	public Customer(String customerID, String userName, String password, String resetPassword, String name, String address, int phoneNumber, String email, Date dob, String gender, Date joinDate) {
		super();
		this.customerID = customerID;
		this.userName = userName;
		this.password = password;
		this.resetPassword = resetPassword;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.joinDate = joinDate;
	}

	

	public Customer(String customerID) {
		super();
		this.customerID = customerID;
	}



	public Customer() {
		super();
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}



	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", userName=" + userName + ", password=" + password
				+ ", resetPassword=" + resetPassword + ", name=" + name + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", dob=" + dob + ", gender=" + gender + ", joinDate=" + joinDate
				+ "]";
	}
	
	
}
