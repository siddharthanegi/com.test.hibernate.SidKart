package com.test.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.hibernate.form.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	public Integer createRecord(Customer customer) {
		// TODO Auto-generated method stub
		return (Integer)sessionFactory.getCurrentSession().save(customer);

	}

	
	@SuppressWarnings("unchecked")
	public List<Customer> listRecords() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from CUSTOMER").list();

	}

	
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return (Customer) sessionFactory.getCurrentSession().createCriteria(Customer.class).add(Restrictions.eq("id",id)).uniqueResult();
	}


	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerByCity(String city) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Customer.class).add(Restrictions.eq("city",city)).list();
	}


	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerByLastName(String lastName) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Customer.class).add(Restrictions.eq("lastName",lastName)).list();
	}

}
