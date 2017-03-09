package com.suki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "id", nullable= false, updatable = false)

	private long id;
@Column(name="username", nullable= false,unique = true)
	private String username;
@Column(name="password", nullable= false)
	private String passwordHash;
	private String email;
@Column(name="role", nullable= false)
	private String role;
	
	public User() {
		super();
	}
	
	

	public User(String username, String passwordHash, String email, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.email = email;
		this.role = role;
	}



	public User(long id, String username, String passwordHash, String email,
			String role) {
		super();
		this.id = id;
		this.username = username;
		this.passwordHash = passwordHash;
		this.email = email;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwordHash="
				+ passwordHash + ", email=" + email + ", role=" + role + "]";
	}

	
	
}
