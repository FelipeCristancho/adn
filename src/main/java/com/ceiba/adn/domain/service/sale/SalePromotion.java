package com.ceiba.adn.domain.service.sale;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.adn.domain.model.Client;
import com.ceiba.adn.domain.model.Dish;
import com.ceiba.adn.domain.model.Sale;
import com.ceiba.adn.domain.port.repository.SaleRepository;

@Service
@Transactional
public class SalePromotion {
	
	/*
	 * - Si un cliente completa los 300000 en compras, su compra actual es gratis.
	 * - Si un cliente llega a su compra número 100 se le dará gratis la actual compra.
	 */
	
	private static final double MONEY_IN_SALES = 100000;
	private static final double QUANTITY_SALES = 2;
	private static final double PROMOTION = 0;
	
	@Autowired
	SaleRepository saleRepository;
	
	public double reachSales(Client client, Dish dish) {
		return saleRepository.findByClient(client).size() == QUANTITY_SALES ? PROMOTION : dish.getPrice();
	}
	
	public double reachAmount(Client client, Dish dish) {
		double totalSales = totalSales(client);
		if(totalSales < MONEY_IN_SALES && totalSales + dish.getPrice() >= MONEY_IN_SALES)
			return PROMOTION;
		return dish.getPrice();
	}
	
	public double totalSales(Client client) {
		List<Sale> sales = saleRepository.findByClient(client);
		double total = 0;
		for(Sale sale : sales) {
			total += sale.getDish().getPrice();
		}
		return total;
	}
}
