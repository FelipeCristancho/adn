package com.ceiba.adn.domain.dto;

public class DtoSalePromotion {
	
	private long dish;
	private long client;
	
	
	public DtoSalePromotion() {
		
	}
	public DtoSalePromotion(long dish, long client) {
		this.dish = dish;
		this.client = client;
	}
	public long getDish() {
		return dish;
	}
	public void setDish(long dish) {
		this.dish = dish;
	}
	public long getClient() {
		return client;
	}
	public void setClient(long client) {
		this.client = client;
	}
	
	
}
