package com.ceiba.adn.aplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ceiba.adn.domain.dto.DtoSalePromotion;
import com.ceiba.adn.domain.model.Client;
import com.ceiba.adn.domain.model.Dish;
import com.ceiba.adn.domain.model.Sale;
import com.ceiba.adn.domain.port.repository.SaleRepository;
import com.ceiba.adn.domain.service.sale.CreateSale;

@Service
@Transactional
public class SaleService {
	
	@Autowired
	SaleRepository saleRepository;
	
	@Autowired
	CreateSale createSale;
	
	public List<Sale> listSales(){
		return saleRepository.findAll();
	}
	
	public ResponseEntity<Sale> verify(DtoSalePromotion sale) {
		return createSale.verifyPromotions(sale);
	}
}
