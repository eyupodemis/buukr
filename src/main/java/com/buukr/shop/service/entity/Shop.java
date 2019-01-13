package com.buukr.shop.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "shop")
public class Shop  {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true)
	@Size(min=2, max=50)
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String phone;
	
	@Column
	private String openninghours;

	
	public Shop() {}
	
	public Shop(Long id, String name, String address, String phone, String openninghours) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.openninghours = openninghours;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
