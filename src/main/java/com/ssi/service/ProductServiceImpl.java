package com.ssi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssi.dao.ProductRepository;
import com.ssi.models.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public Product productDetails(int code) {
		//fetch the product details  using repository
		Product product =productRepository.searchProduct(code);
		//compute the discount
		
		if(product.getPrice()>=5000)
		{
			product.setDiscount(product.getPrice()*20/100);
		}
		else
		{
			product.setDiscount(product.getPrice()*10/100);
		}
           return product;
	}

}
