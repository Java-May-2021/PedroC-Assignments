package com.pcalixto.productsandcategories.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity()
@Table(name="hmk_java030305_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 50)
    private String name;

    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    private List<CategoryProduct> categoriesProducts;

    public Category() {
    	
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

	public List<CategoryProduct> getCategoriesProducts() {
		return categoriesProducts;
	}

	public void setCategoriesProducts(List<CategoryProduct> categoriesProducts) {
		this.categoriesProducts = categoriesProducts;
	}
    
    
}
