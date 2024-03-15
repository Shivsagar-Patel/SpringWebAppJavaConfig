package com.ssi.dao;

import java.util.List;

import com.ssi.models.Product;

public interface ProductRepository {
public Product searchProduct(int code);
public Product saveProduct(Product product);
public Product deleteProduct(int code);
public List<Product> getAllProducts();
}
