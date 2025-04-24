package com.mockbean.mockbean.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
public class Customer {
	
	@Id
	int custId;
	String address;
	int age;
	String custName;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int custId, String address, int age, String custName) {
		this.custId = custId;
		this.address = address;
		this.age = age;
		this.custName = custName;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	
	

}
