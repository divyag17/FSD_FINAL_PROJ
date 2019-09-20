package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data 
@Table(name="usertable")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="ulocation")
	private String ulocation;
	@Column(name="avialability")
	private String avialability;
	@Column(name="email")
	private String email;
	@Column(name="img")
	private String img;
	@Column(name="udoamin")
	private String udomain;
	@Column(name="previous_project")
	private String previous_project;
	@Column(name="current_Project")
	@ManyToOne(fetch = FetchType.LAZY)
	private Project current_project;

	public User(String username, String ulocation, String avialability, String email, String img, String udomain,
			String previous_project) {
		super();
		this.username = username;
		this.ulocation = ulocation;
		this.avialability = avialability;
		this.email = email;
		this.img = img;
		this.udomain = udomain;
		this.previous_project = previous_project;
	}
	
	public User(String username, String password, String ulocation, String avialability, String email, String img,
			String udomain, String previous_project) {
		super();
		this.username = username;
		this.password = password;
		this.ulocation = ulocation;
		this.avialability = avialability;
		this.email = email;
		this.img = img;
		this.udomain = udomain;
		this.previous_project = previous_project;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUlocation() {
		return ulocation;
	}

	public void setUlocation(String ulocation) {
		this.ulocation = ulocation;
	}

	public String getAvialability() {
		return avialability;
	}

	public void setAvialability(String avialability) {
		this.avialability = avialability;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUdomain() {
		return udomain;
	}

	public void setUdomain(String udomain) {
		this.udomain = udomain;
	}

	public Project getCurrent_project() {
		return current_project;
	}

	public void setCurrent_project(Project current_project) {
		this.current_project = current_project;
	}

	public String getPrevious_project() {
		return previous_project;
	}

	public void setPrevious_project(String previous_project) {
		this.previous_project = previous_project;
	}

	

	
}