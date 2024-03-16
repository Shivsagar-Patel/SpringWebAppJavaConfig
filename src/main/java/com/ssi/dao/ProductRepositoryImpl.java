package com.ssi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssi.models.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Product deleteProduct(int code) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Product product=session.get(Product.class,code);
		session.delete(product);
		tr.commit();
		session.close();
		return product;
		
	}

	public Product saveProduct(Product product) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(product);
		tr.commit();
		session.close();
		return product;
		
	}
	public Product searchProduct(int code) {
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class,code);
		session.close();
		return product;
	}

	public List<Product> getAllProducts() {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> products=criteria.list();
		session.close();
		return products;
		
	}

	

}
