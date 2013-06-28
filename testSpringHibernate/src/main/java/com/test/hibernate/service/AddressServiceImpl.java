package com.test.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.hibernate.dao.AddressDAO;
import com.test.hibernate.form.Address;
@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDAO addressDAO;

	
	@Transactional
	public void createAddress(Address address) {
		// TODO Auto-generated method stub
		addressDAO.createAddress(address);
	}


	@Transactional
	public List<Address> getAllRecords() {
		// TODO Auto-generated method stub
		return addressDAO.getAllRecords();
	}

	
	@Transactional
	public Address getAddressByID(Integer id) {
		// TODO Auto-generated method stub
		return addressDAO.getAddressByID(id);
	}

	
	@Transactional
	public Address getAddressByCityName(String cityName) {
		// TODO Auto-generated method stub
		return addressDAO.getAddressByCityName(cityName);
	}

}
