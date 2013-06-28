package com.test.hibernate.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.test.hibernate.form.Customer;
import com.test.hibernate.form.OrderInfo;

  public interface OrderService {

	  Integer createOrder(OrderInfo order);
	  OrderInfo getOrderById(Integer id);
	  Set<OrderInfo> getOrderByCustId(Customer customer);
	  List<OrderInfo> getAllOrders();
	  void deleteOrder(OrderInfo order);
	  Set<OrderInfo> getOrderBetweenDates(Date fromDate,Date toDate);
}
