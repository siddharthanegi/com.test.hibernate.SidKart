package com.test.hibernate.dao;

import java.util.List;

import com.test.hibernate.form.Category;

 public interface CategoryDAO {
	
	  Integer createCategory(Category category);
	  Category getCategoryByID(Integer id);
	  Category getCategoryByName(String category);
	  List<Category> getAllCategories();
	  void deleteCategory(Category category);
	
}
