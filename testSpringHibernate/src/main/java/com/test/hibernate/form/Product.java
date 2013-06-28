package com.test.hibernate.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@XmlRootElement(name="Product")

@Entity(name="Products")
public class Product {
	@Id
	@GeneratedValue
	@Column(name="pid")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="quantity")
	private Integer quantity;

	@ManyToOne(fetch=FetchType.EAGER)
	@Cascade({CascadeType.ALL})
	@JoinColumn(name="address")
	private Address address;
	
	

	@ManyToOne(fetch=FetchType.EAGER)
	@Cascade({CascadeType.ALL})
	@JoinColumn(name="category")
	private Category category;

	
	@Column(name="price")
	private Integer price;
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
