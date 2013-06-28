package com.test.hibernate.service;

import java.util.List;

import com.test.hibernate.form.Customer;

 public interface CustomerService {

	  Integer createRecord(Customer customer);
	  List<Customer> listRecords();
	  Customer getCustomerById(Integer id);
	  List<Customer> getCustomerByCity(String city);
	  List<Customer> getCustomerByLastName(String lastName);
}
