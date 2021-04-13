package com.ceiba.adn.domain.service.sale;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.adn.domain.model.Sale;
import com.ceiba.adn.domain.port.repository.SaleRepository;
import com.ceiba.adn.domain.service.generalRules.MostRepeatedElement;

@Service
public class ShowDishMostSale {
	
	@Autowired
	MostRepeatedElement mostRepeatedElement;
	
	@Autowired
	SaleRepository saleRepository;
	
	public List<Long> listAllDishesId() {
		List<Sale> sales = saleRepository.findAll();
		List<Long> listDishesId = new ArrayList<>();
		
		for (int i = 0; i < sales.size(); i++) {
			listDishesId.add(sales.get(i).getDish().getdishId());
		}
		return listDishesId;		
	}
	
	public long getMostSale() {
		List<Long> listDishesId = listAllDishesId();
		return  mostRepeatedElement.getMostRepeatedElement(listDishesId);
	}

}
