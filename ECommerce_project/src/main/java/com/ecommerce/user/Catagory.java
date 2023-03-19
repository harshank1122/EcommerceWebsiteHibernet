package com.ecommerce.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Catagory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String CatagoryTitle;
	private String CatagoryDescription;
	@OneToMany(mappedBy = "catagory")
	private List<Product> product = new ArrayList<Product>();

	public Catagory(int categoryId, String catagoryTitle, String catagoryDescription) {
		super();
		this.categoryId = categoryId;
		CatagoryTitle = catagoryTitle;
		CatagoryDescription = catagoryDescription;
	}

	public Catagory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Catagory(String catagoryTitle, String catagoryDescription, List<Product> product) {
		super();
		CatagoryTitle = catagoryTitle;
		CatagoryDescription = catagoryDescription;
		this.product = product;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCatagoryTitle() {
		return CatagoryTitle;
	}

	public void setCatagoryTitle(String catagoryTitle) {
		CatagoryTitle = catagoryTitle;
	}

	public String getCatagoryDescription() {
		return CatagoryDescription;
	}

	public void setCatagoryDescription(String catagoryDescription) {
		CatagoryDescription = catagoryDescription;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Catagory [categoryId=" + categoryId + ", CatagoryTitle=" + CatagoryTitle + ", CatagoryDescription="
				+ CatagoryDescription + ", product=" + product + "]";
	}

}
