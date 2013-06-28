package com.test.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.hibernate.form.Address;
@Repository
public class AddressDAOImpl implements AddressDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void createAddress(Address address) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(address);
	}


	@SuppressWarnings("unchecked")
	public List<Address> getAllRecords() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Address").list();
	}

	
	public Address getAddressByID(Integer id) {
		// TODO Auto-generated method stub
		return (Address) sessionFactory.getCurrentSession().createCriteria(Address.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	
	public Address getAddressByCityName(String cityName) {
		// TODO Auto-generated method stub
	
		return (Address) sessionFactory.getCurrentSession().createCriteria(Address.class).add(Restrictions.eq("cityName", cityName)).uniqueResult();
	}

}
