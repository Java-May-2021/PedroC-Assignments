package com.pcalixto.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pcalixto.productsandcategories.models.Category;
import com.pcalixto.productsandcategories.models.Product;
import com.pcalixto.productsandcategories.repositories.CategoryRepository;

@Service()
public class CategoryService {
	CategoryRepository repo;
	
	public CategoryService(CategoryRepository repo) {
		this.repo = repo;
	}
	
	public Category createCategory(Category category) {
		return repo.save(category);
	}

	public Category findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public List<Category> findAll() {
		return repo.findAll();
	}

}
