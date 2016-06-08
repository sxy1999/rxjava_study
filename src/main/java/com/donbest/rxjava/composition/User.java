package com.donbest.rxjava.composition;

public class User {
	private String name;
	private String email;
	UserSecurityStatus securityStatus;

	public User(String name, String email, UserSecurityStatus securityStatus) {
		this.name = name;
		this.email = email;
		this.securityStatus = securityStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserSecurityStatus getSecurityStatus() {
		return securityStatus;
	}

	public void setSecurityStatus(UserSecurityStatus securityStatus) {
		this.securityStatus = securityStatus;
	}

	public String toJSON() {
		
		return "{ name : "+name+", "+"email : "+email+" }";
	}
}
