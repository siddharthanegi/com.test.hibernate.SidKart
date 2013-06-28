package com.test.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.hibernate.dao.CustomerDAO;
import com.test.hibernate.form.Customer;
import com.test.hibernate.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	public Integer createRecord(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.createRecord(customer);
	}

	
	@Transactional
	public List<Customer> listRecords() {
		// TODO Auto-generated method stub
		return customerDAO.listRecords();
	}

	
	@Transactional
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerById(id);
	}

	@Transactional
	public List<Customer> getCustomerByCity(String city) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerByCity(city);
	}

	@Transactional
	public List<Customer> getCustomerByLastName(String lastName) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerByLastName(lastName);
	}

}
