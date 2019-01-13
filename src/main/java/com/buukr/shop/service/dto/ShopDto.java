package com.buukr.shop.service.dto;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

@Component
public class ShopDto   {

	private String name;
	
	private String address;

	private String phone;

	private String openninghours;
	
	public ShopDto(String name, String address, String phone, String openninghours) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.openninghours = openninghours;
	}

	public ShopDto() {}
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getopenninghours() {
		return openninghours;
	}

	public void setopenninghours(String openninghours) {
		this.openninghours = openninghours;
	}
	
	
	
}
