package com.ceiba.adn.domain.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dishes")
public class Dish{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dish_id")
	private long dishId;
	
	@Column(name = "dish_name")
	private String dishName;
	
	private double price;

	public Dish(int dishId, String dishName, double price) {
		this.dishId = dishId;
		this.dishName = dishName;
		this.price = price;
	}

	public Dish() {		
	}	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getdishId() {
		return dishId;
	}

	public void setdishId(long dishId) {
		this.dishId = dishId;
	}

	public String getdishName() {
		return dishName;
	}

	public void setdishName(String dishName) {
		this.dishName = dishName;
	}
}
