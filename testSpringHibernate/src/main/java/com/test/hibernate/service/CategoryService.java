package com.test.hibernate.service;

import java.util.List;

import com.test.hibernate.form.Category;

 public interface CategoryService {

      Integer createCategory(Category category);
	  Category getCategoryByID(Integer id);
	  List<Category> getAllCategories();
	  void deleteCategory(Category category);
	  Category getCategoryByName(String category);
}
