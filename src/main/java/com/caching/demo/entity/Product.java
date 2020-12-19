package com.caching.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="PRODUCTS")
public class Product implements Serializable{

	private static final long serialVersionUID = 3319885656702858390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Version
	private Long version;
	
	private String name;
	private String description;
	private Double price;
	private boolean checkout;
	
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
	public boolean isCheckout() {
		return checkout;
	}
	public void setCheckout(boolean checkout) {
		this.checkout = checkout;
	}
	public Long getVersion() {
		return version;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", version=" + version + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", checkout=" + checkout + "]";
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	
}
