package com.taxApp.model;

import javax.persistence.*;


@Entity
public class appUser {
	
	
	@Id	
	private String email;
	@Column
	private String dob;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column(name = "password", nullable = false)
	private String password;
	@Column
	private String id;
	
	public appUser(String _firstname) {
		// TODO Auto-generated constructor stub
		this.setFirstName(_firstname);
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
