package com.test.hibernate.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.hibernate.dao.OrderDAO;
import com.test.hibernate.form.Customer;
import com.test.hibernate.form.OrderInfo;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	
	
	
	@Transactional
	public Integer createOrder(OrderInfo order) {
		// TODO Auto-generated method stub
		return orderDAO.createOrder(order);
	}

	
	@Transactional	
	public OrderInfo getOrderById(Integer id) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderById(id);
	}

	
	@Transactional
	public Set<OrderInfo> getOrderByCustId(Customer customer) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderByCustId(customer);
	}


	@Transactional
	public List<OrderInfo> getAllOrders() {
		// TODO Auto-generated method stub
		return orderDAO.getAllOrders();
	}

	@Transactional
	public void deleteOrder(OrderInfo order) {
		// TODO Auto-generated method stub
		orderDAO.deleteOrder(order);
	}

	@Transactional
	public Set<OrderInfo> getOrderBetweenDates(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderBetweenDates(fromDate, toDate);
	}

}
