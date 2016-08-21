package com.niit.E_ComBack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "USER_DETAILS")
@Component

public class UserDetails {

	@Id
	private String email;
	private String name;
	private String address;
	@Column(name = "phone_no")
	private String phone_no;
	private String password;

	private boolean admin;

	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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



	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}



	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}




	public boolean isAdmin() {
		return admin;
	}



	public void setAdmin(boolean admin) {
		this.admin = admin;
	}



	
	

}
