package com.ssi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssi.models.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Product searchProduct(int code) {
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class,code);
		session.close();
		return product;
	}

}
