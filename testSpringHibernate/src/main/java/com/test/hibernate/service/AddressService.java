package com.test.hibernate.service;

import java.util.List;

import com.test.hibernate.form.Address;

public interface AddressService {
	
	  void createAddress(Address address);
	  List<Address> getAllRecords();
	  Address getAddressByID(Integer id);
	  Address getAddressByCityName(String cityName);

}
