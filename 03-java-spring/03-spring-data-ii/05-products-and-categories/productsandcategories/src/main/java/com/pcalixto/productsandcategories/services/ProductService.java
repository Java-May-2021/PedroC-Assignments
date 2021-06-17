package com.pcalixto.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pcalixto.productsandcategories.models.Product;
import com.pcalixto.productsandcategories.repositories.ProductRepository;

@Service()
public class ProductService {
	ProductRepository repo;
	
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}
	
	public Product createProduct(Product product) {
		return repo.save(product);
	}
	
	public Product findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public List<Product> findAll() {
		return repo.findAll();
	}
}
