package com.test.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.hibernate.form.Category;
@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Category getCategoryByID(Integer id) {
		// TODO Auto-generated method stub
	
		return (Category) sessionFactory.getCurrentSession().createCriteria(Category.class).add(Restrictions.eq("id", id)).uniqueResult(); 
	
		
	}
	

	@SuppressWarnings("unchecked")
	
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	
	public void deleteCategory(Category category) {
		sessionFactory.getCurrentSession().delete(category);
	}

	
	public Integer createCategory(Category category) {
		// TODO Auto-generated method stub
		return (Integer) sessionFactory.getCurrentSession().save(category);
	}

	
	public Category getCategoryByName(String category) {
		// TODO Auto-generated method stub
		return (Category) sessionFactory.getCurrentSession().createCriteria(Category.class).add(Restrictions.eq("category", category)).uniqueResult(); 
				
	}

}
