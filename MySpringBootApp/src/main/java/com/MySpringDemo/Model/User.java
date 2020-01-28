package com.MySpringDemo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myusertable",schema="new_schema_shan1")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="username")
	private String userName;
	@Column(name="firstname")
	private String firtsName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="age")
	private int age;
	@Column(name="password")
	private String password;
	
	public User(String userName, String firtsName, String lastName, int age, String password) {
		super();
		this.userName = userName;
		this.firtsName = firtsName;
		this.lastName = lastName;
		this.age = age;
		this.password = password;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirtsName() {
		return firtsName;
	}
	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firtsName=" + firtsName + ", lastName=" + lastName
				+ ", age=" + age + ", password=" + password + "]";
	}
	
	
}
