package com.test.hibernate.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.hibernate.form.Customer;
import com.test.hibernate.form.OrderInfo;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public Integer createOrder(OrderInfo order) {
		// TODO Auto-generated method stub
		return (Integer) sessionFactory.getCurrentSession().save(order);
	}

	public OrderInfo getOrderById(Integer id) {
		// TODO Auto-generated method stub
		return (OrderInfo) sessionFactory.getCurrentSession().createCriteria(OrderInfo.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	
	@SuppressWarnings("unchecked")
	public Set<OrderInfo> getOrderByCustId(Customer customer) {
		// TODO Auto-generated method stub
		
		List<OrderInfo> orderList= sessionFactory.getCurrentSession().createCriteria(OrderInfo.class).add(Restrictions.eq("customer",customer)).list();
	   return new HashSet<OrderInfo>(orderList);
	   
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderInfo> getAllOrders() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from OrderInfo").list();
	}

	public void deleteOrder(OrderInfo order) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().delete(order);
	}

	@SuppressWarnings("unchecked")
	public Set<OrderInfo> getOrderBetweenDates(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		List<OrderInfo> order= sessionFactory.getCurrentSession().createCriteria(OrderInfo.class).add(Restrictions.between("orderDate", fromDate, toDate)).list();
		return new HashSet<OrderInfo>(order);
		
	}	

}
