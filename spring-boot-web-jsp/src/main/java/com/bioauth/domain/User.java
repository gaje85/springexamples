package com.bioauth.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "user", catalog = "votemanagement")

public class User {
	
	int userid;
	String firstname;
	String lastname;
	Date dob;
	int age;
	String phone;
	String address;
	Long aadhaarid;
	
	public User(){
		
	}
	
	public User(int userid,	String firstname,String lastname,Date dob,int age,String phone,String address,Long aadhaarid){
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
		this.age = age;
		this.aadhaarid = aadhaarid;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userid", unique = true, nullable = false)
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
		@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "dob")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Column(name = "age")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Column(name = "aadhaarid")
	public Long getAadhaarid() {
		return aadhaarid;
	}

	public void setAadhaarid(Long aadhaarid) {
		this.aadhaarid = aadhaarid;
	}
	
}
