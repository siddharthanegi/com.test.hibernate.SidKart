package com.test.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.hibernate.dao.ProductDAO;
import com.test.hibernate.form.Category;
import com.test.hibernate.form.Product;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	
	@Transactional
	public void createRecord(Product product) {
		// TODO Auto-generated method stub
		productDAO.createRecord(product);
		
	}

	
	@Transactional
	public List<Product> listRecords() {
		// TODO Auto-generated method stub
		return productDAO.listRecords();
	}


	@Transactional
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return productDAO.getProductById(id);
	}


	@Transactional
	public List<Product> orderBy(String choice,int startPage,int max) {
		// TODO Auto-generated method stub
		return productDAO.orderBy(choice,startPage,max);
	}

	
	@Transactional
	public Long getCount() {
		// TODO Auto-generated method stub
		return productDAO.getCount();
	}

	
	@Transactional
	public List<Product> pagiNate(int startPage) {
		// TODO Auto-generated method stub
		return productDAO.pagiNate(startPage);
	}


	@Transactional
	public List<Product> getProductByCategory(Category category) {
		// TODO Auto-generated method stub
		return productDAO.getProductByCategory(category);
	}

	
	@Transactional
	public void alterQuantity(Integer id, Integer newQuantity) {
		// TODO Auto-generated method stub
		productDAO.alterQuantity(id, newQuantity);
		
	}

	@Transactional
	public List<Product> getProductByCategoryAndPrice(Category category,
			int startPrice, int maxPrice) {
		// TODO Auto-generated method stub
		return productDAO.getProductByCategoryAndPrice(category, startPrice, maxPrice);
	}
	
	
}
