package com.ceiba.adn.domain.service.sale;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ceiba.adn.domain.dto.DtoSalePromotion;
import com.ceiba.adn.domain.model.Client;
import com.ceiba.adn.domain.model.Dish;
import com.ceiba.adn.domain.model.Sale;
import com.ceiba.adn.domain.port.repository.ClientRepository;
import com.ceiba.adn.domain.port.repository.DishRepository;
import com.ceiba.adn.domain.port.repository.SaleRepository;

@Service
@Transactional
public class CreateSale {
	
	String message = "El valor de esta venta fue de :";
	String messageClientNotFound = "Cliente no encontrado";
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SalePromotion salePromotion;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	DishRepository dishRepository;
	
	
	public ResponseEntity<Sale> verifyPromotions(DtoSalePromotion sale) {
		if (existDishAndClient(sale.getDish(), sale.getClient())) {
			Optional<Client> client = clientRepository.findById(sale.getClient());
			Optional<Dish> dish = dishRepository.findById(sale.getDish());			
			Sale newSale = new Sale(dish.get(), client.get());
			double reachAmount = salePromotion.reachAmount(client.get(), dish.get());
			double reachSales = salePromotion.reachSales(client.get(), dish.get());
			double valueOfSale = calculatePriceOfSale(reachAmount, reachSales);
			saleRepository.save(newSale);
			return new ResponseEntity(message+valueOfSale,HttpStatus.OK);
		}
		return new ResponseEntity(messageClientNotFound,HttpStatus.BAD_REQUEST);
	}
	
	public double calculatePriceOfSale(double x, double y) {
		if(x < y)
			return x;
		return y;
	}
	
	public Dish findDish(long id) {
		Optional<Dish> dish = dishRepository.findById(id);
		if(dish.isPresent())
			return dish.get();
		return null;
	}
	
	public Client findClient(long identification) {
		Optional<Client> client = clientRepository.findById(identification);
		if(client.isPresent())
			return client.get();
		return null;
	}
	
	public boolean existDishAndClient(long dishId, long clientId) {
		boolean clientExist = clientRepository.existsById(clientId);
		boolean dishExist = dishRepository.existsById(dishId);
		return clientExist && dishExist;
	}
}
