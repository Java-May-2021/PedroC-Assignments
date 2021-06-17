package com.pcalixto.productsandcategories.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pcalixto.productsandcategories.models.Category;
import com.pcalixto.productsandcategories.models.CategoryProduct;
import com.pcalixto.productsandcategories.models.Product;
import com.pcalixto.productsandcategories.services.CategoryProductService;
import com.pcalixto.productsandcategories.services.CategoryService;
import com.pcalixto.productsandcategories.services.ProductService;

@Controller()
public class MainController {
	private final ProductService productService;
	private final CategoryService categoryService;
	private final CategoryProductService categoryProductService;
	
	public MainController(ProductService productService,
						  CategoryService categoryService,
						  CategoryProductService categoryProductService) {
		this.productService = productService;
		this.categoryService = categoryService;
		this.categoryProductService = categoryProductService;
	}
	
	@GetMapping("products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}

	@PostMapping("products/new")
	public String newProduct(@Valid @ModelAttribute("product") Product product, 
			 				 BindingResult result) {
        if (!result.hasErrors()) {
        	product = productService.createProduct(product);
            return "redirect:/products/" + product.getId();
        } else {
    		return "/products/new.jsp";
        }
	}

	@GetMapping("categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}

	@PostMapping("categories/new")
	public String newCategory(@Valid @ModelAttribute("category") Category category, 
			 				  BindingResult result) {
        if (!result.hasErrors()) {
        	category = categoryService.createCategory(category);
            return "redirect:/categories/" + category.getId();
        } else {
    		return "/categories/new.jsp";
        }
	}

	@GetMapping("products/{id}")
	public String editProduct(@PathVariable("id") Long id, 
							  Model viewmodel) {
		Product product = productService.findById(id);
		viewmodel.addAttribute("product", product);

		List<CategoryProduct> catProds = product.getCategoriesProducts();
		List<Category> associatedCategories = new ArrayList<Category>();
		for (CategoryProduct catProd: catProds)
		{
			// System.out.println(catProd.getCategory().getName());
			associatedCategories.add(catProd.getCategory());
		}

		// System.out.println("---");
				
		List<Category> categories = categoryService.findAll();
		List<Category> availableCategories = new ArrayList<Category>();
		for (Category cat: categories)
		{
			boolean shouldAdd = true;
			for (Category assocCat: associatedCategories)
			{
				if (cat.getId().equals(assocCat.getId())) {
					shouldAdd = false;
				}
			}
			
			if (shouldAdd) {
				// System.out.println(cat.getName());
				availableCategories.add(cat);
			}
		}
		viewmodel.addAttribute("associatedCategories", associatedCategories);
		viewmodel.addAttribute("availableCategories", availableCategories);
		
		return "/products/edit.jsp";
	}
    
	@PostMapping("products/{id}")
	public String editProduct(@PathVariable("id") Long id,
							  @RequestParam(value="categoryId", required=true) Long categoryId,
			  				  Model viewmodel) {
		Product product = productService.findById(id);
		Category category = categoryService.findById(categoryId);
		categoryProductService.addCategoryProduct(product, category);
		
        return "redirect:/products/" + product.getId();
	}

	@GetMapping("categories/{id}")
	public String editCategory(@PathVariable("id") Long id, 
			  				   Model viewmodel) {
		Category category = categoryService.findById(id);
		viewmodel.addAttribute("category", category);

		List<CategoryProduct> catProds = category.getCategoriesProducts();
		List<Product> associatedProducts = new ArrayList<Product>();
		for (CategoryProduct catProd: catProds)
		{
			System.out.println(catProd.getProduct().getName());
			associatedProducts .add(catProd.getProduct());
		}

		System.out.println("---");
				
		List<Product> products = productService.findAll();
		List<Product> availableProducts = new ArrayList<Product>();
		for (Product prod: products)
		{
			boolean shouldAdd = true;
			for (Product assocProd: associatedProducts)
			{
				if (prod.getId().equals(assocProd.getId())) {
					shouldAdd = false;
				}
			}
			
			if (shouldAdd) {
				System.out.println(prod.getName());
				availableProducts.add(prod);
			}
		}
		viewmodel.addAttribute("associatedProducts", associatedProducts);
		viewmodel.addAttribute("availableProducts", availableProducts);

		return "/categories/edit.jsp";
	}
	
	@PostMapping("categories/{id}")
	public String editCategory(@PathVariable("id") Long id,
							   @RequestParam(value="productId", required=true) Long productId,
							   Model viewmodel) {
		Category category = categoryService.findById(id);
		Product product = productService.findById(productId);
		categoryProductService.addCategoryProduct(product, category);
		
        return "redirect:/categories/" + category.getId();
	}
	
}
