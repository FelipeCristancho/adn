package com.ceiba.adn.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.aplication.service.SaleService;
import com.ceiba.adn.domain.dto.DtoSalePromotion;
import com.ceiba.adn.domain.model.Client;
import com.ceiba.adn.domain.model.Dish;
import com.ceiba.adn.domain.model.Sale;
import com.ceiba.adn.domain.port.repository.ClientRepository;
import com.ceiba.adn.domain.port.repository.DishRepository;
import com.ceiba.adn.domain.port.repository.SaleRepository;
import com.ceiba.adn.domain.service.sale.CreateSale;


@RestController
@RequestMapping("/api/sale")
@CrossOrigin(origins = "*")
public class SaleController {
	
	@Autowired
	SaleService saleService;
	
	@Autowired
	CreateSale createSale;
	
	@Autowired
	SaleRepository SaleRepository; 
	
	@Autowired
	DishRepository dishRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<Sale>> listSales(){
		List<Sale> sales = saleService.listSales();
		return new ResponseEntity<List<Sale>>(sales, HttpStatus.OK);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Sale> createSale(@RequestBody DtoSalePromotion sale){
		return saleService.verify(sale);		
	}
	
}
