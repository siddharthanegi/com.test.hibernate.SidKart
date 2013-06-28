package com.test.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.hibernate.dao.CategoryDAO;
import com.test.hibernate.form.Category;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	

	@Transactional
	public Integer createCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDAO.createCategory(category);
	}

	
	@Transactional
	public Category getCategoryByID(Integer id) {
		// TODO Auto-generated method stub
		return categoryDAO.getCategoryByID(id);
	}

	
	@Transactional
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDAO.getAllCategories();
	}


	@Transactional
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.deleteCategory(category);
	}


	@Transactional
	public Category getCategoryByName(String category) {
		// TODO Auto-generated method stub
		return categoryDAO.getCategoryByName(category);
	}

}
