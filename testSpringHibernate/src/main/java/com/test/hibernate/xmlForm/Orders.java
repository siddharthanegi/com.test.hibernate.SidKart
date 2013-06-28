package com.test.hibernate.xmlForm;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.test.hibernate.form.OrderInfo;

@XmlRootElement(name="orders")
public class Orders {
	
	private List<OrderInfo> order;
	public List<OrderInfo> getOrder() {
		return order;
	}

	public void setOrder(List<OrderInfo> order) {
		this.order = order;
	}



}
