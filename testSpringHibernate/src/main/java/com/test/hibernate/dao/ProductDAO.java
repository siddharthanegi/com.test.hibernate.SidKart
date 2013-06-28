package com.test.hibernate.dao;

import java.util.List;

import com.test.hibernate.form.Category;
import com.test.hibernate.form.Product;

 public interface ProductDAO {

	  void createRecord(Product product);
	  List<Product> listRecords();
	  Product getProductById(Integer id);
	  List<Product> orderBy(String choice,int startPage,int max);
	  Long getCount();
	  List<Product> pagiNate(int startPage);
	  List<Product> getProductByCategory(Category category);
	  void alterQuantity(Integer id, Integer newQuantity);
	  List<Product> getProductByCategoryAndPrice(Category category,int startPrice, int maxPrice);
	
}
