package com.ssi.service;

import java.util.List;

import com.ssi.models.Product;

public interface ProductService {
	public Product productDetails(int code);
	public Product saveProduct(Product product);
	public Product deleteProduct(int code);
	public List<Product> getAllProducts();

}
