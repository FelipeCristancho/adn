package com.ceiba.adn.domain.dto;

public class DtoSale {
	
	private long id;
	private String saleDate;
	private String dish;
	private String client;
	
	public DtoSale() {		
	}
	
	public DtoSale(long id, String saleDate, String dish, String client) {
		this.id = id;
		this.saleDate = saleDate;
		this.dish = dish;
		this.client = client;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public String getDish() {
		return dish;
	}
	public void setDish(String dish) {
		this.dish = dish;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}	
}
