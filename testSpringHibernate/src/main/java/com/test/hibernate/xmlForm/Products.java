package com.test.hibernate.xmlForm;

import java.util.List;


import javax.xml.bind.annotation.XmlRootElement;

import com.test.hibernate.form.Product;
@XmlRootElement(name="Products")
public class Products {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
