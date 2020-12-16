package com.bank.pojo;

public class NewCustomer {
	int AccountNumber ;
	String Name;
	String UserName;
	String Password;
	String Email;
	int Amount;
	String Address;
	int Mobile;
	public NewCustomer(int accountNumber, String name, String userName, String password, String email, int amount,
			String address, int mobile) {
		super();
		AccountNumber = accountNumber;
		Name = name;
		UserName = userName;
		Password = password;
		Email = email;
		Amount = amount;
		Address = address;
		Mobile = mobile;
	}
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getMobile() {
		return Mobile;
	}
	public void setMobile(int mobile) {
		Mobile = mobile;
	}
	

}
