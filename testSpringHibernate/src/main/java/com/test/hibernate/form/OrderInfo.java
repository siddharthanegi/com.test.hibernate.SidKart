package com.test.hibernate.form;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="order")
@Entity(name="OrderInfo")
public class OrderInfo {
	
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Order_Products", 
	            joinColumns={@JoinColumn(name="ORDER_ID")}, 
	            inverseJoinColumns={@JoinColumn(name="PRODUCT_ID")})
	private Set<Product> product;

	@Column(name="order_date")
	private Date orderDate;
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {

		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	
	
}
