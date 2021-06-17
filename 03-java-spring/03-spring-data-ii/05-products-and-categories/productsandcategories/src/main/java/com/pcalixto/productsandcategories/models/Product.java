package com.pcalixto.productsandcategories.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity()
@Table(name="hmk_java030305_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Size(min = 2, max = 50)
    private String name;

    @Size(min = 0, max = 500)
    private String description;
    
    @Min(0)
    @Max(999)
    private Double price;

    @OneToMany(mappedBy="product", fetch = FetchType.LAZY)
    private List<CategoryProduct> categoriesProducts;
    
	public Product() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<CategoryProduct> getCategoriesProducts() {
		return categoriesProducts;
	}

	public void setCategoriesProducts(List<CategoryProduct> categoriesProducts) {
		this.categoriesProducts = categoriesProducts;
	}
	
}
