package com.test.hibernate.dao;

import java.util.List;

import com.test.hibernate.form.Address;

 public interface AddressDAO {
	
	  void createAddress(Address address);
	  List<Address> getAllRecords();
	  Address getAddressByID(Integer id);
	  Address getAddressByCityName(String cityName);
}
