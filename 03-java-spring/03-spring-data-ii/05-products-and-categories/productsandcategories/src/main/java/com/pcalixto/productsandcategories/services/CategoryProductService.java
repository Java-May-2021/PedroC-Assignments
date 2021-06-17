package com.pcalixto.productsandcategories.services;

import org.springframework.stereotype.Service;

import com.pcalixto.productsandcategories.models.Category;
import com.pcalixto.productsandcategories.models.CategoryProduct;
import com.pcalixto.productsandcategories.models.Product;
import com.pcalixto.productsandcategories.repositories.CategoryProductRepository;

@Service()
public class CategoryProductService {
	CategoryProductRepository repo;
	
	public CategoryProductService(CategoryProductRepository repo) {
		this.repo = repo;
	}
	
	public void addCategoryProduct(Product product, Category category) {
		CategoryProduct cp = new CategoryProduct();
		cp.setProduct(product);
		cp.setCategory(category);
		repo.save(cp);
	}
}
