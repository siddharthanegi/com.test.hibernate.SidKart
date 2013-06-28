package com.test.hibernate.dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.hibernate.form.Category;
import com.test.hibernate.form.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	private static final int MAX_RESULTS=5;
	private static final String UNCHECKED="unchecked";
	@Autowired
	private SessionFactory sessionFactory;


	public void createRecord(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(product);

	}


	@SuppressWarnings(UNCHECKED)
	public List<Product> listRecords() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Products");

		
		return query.list();
	
	}

	
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return (Product) sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("id", id)).uniqueResult();
			}

	
	@SuppressWarnings(UNCHECKED)
	public List<Product> orderBy(String choice, int startPage, int max) {
		// TODO Auto-generated method stub
		int start= (startPage-1)*MAX_RESULTS;
		List<Product> allRecords=sessionFactory.getCurrentSession().createCriteria(Product.class).setFirstResult(start).setMaxResults(max).addOrder(Order.asc(choice)).list();
	
		return allRecords;
		
	}

	
	public Long getCount() {
		// TODO Auto-generated method stub
		return (Long) sessionFactory.getCurrentSession().createCriteria(Product.class).setProjection(Projections.rowCount()).uniqueResult();
	}


	@SuppressWarnings(UNCHECKED)
	public List<Product> pagiNate(int startPage) {
		// TODO Auto-generated method stub
		int start= (startPage-1)*MAX_RESULTS;
		Query query=sessionFactory.getCurrentSession().createQuery("from Products");
		query.setFirstResult(start);
		query.setMaxResults(MAX_RESULTS);
		return query.list();
	}


	@SuppressWarnings(UNCHECKED)
	public List<Product> getProductByCategory(Category category) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("category", category)).list();
	}

	public void alterQuantity(Integer id, Integer newQuantity) {
		// TODO Auto-generated method stub
		Product product = new Product();
		Session session=sessionFactory.openSession();
		product= (Product) session.load(Product.class, id);
		Transaction tx=session.beginTransaction();
		product.setQuantity(newQuantity);
		tx.commit();
		session.close();
		
	}


	@SuppressWarnings(UNCHECKED)
	public List<Product> getProductByCategoryAndPrice(Category category,
			int startPrice, int maxPrice) {
		// TODO Auto-generated method stub
		
		if(category==null){
			return sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.between("price", startPrice,maxPrice)).list();
			}
		else{
		return sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("category", category)).add(Restrictions.between("price", startPrice,maxPrice)).list();
		
		}
	}

}
