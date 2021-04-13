package com.ceiba.adn.domain.service.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.adn.domain.dto.DtoSale;
import com.ceiba.adn.domain.model.Client;
import com.ceiba.adn.domain.model.Sale;
import com.ceiba.adn.domain.port.repository.SaleRepository;

@Service
public class ShowSales {
	
	@Autowired
	SaleRepository saleRepository;
	
	public List<Sale> listSalesByClient(Client client){
		return saleRepository.findByClient(client);
	}
	
	public List<DtoSale> convertOutputSales(Client client){
		List<Sale> sales = saleRepository.findByClient(client);
		List<DtoSale> outputList = new ArrayList<DtoSale>(); 
		for (int i = 0; i < sales.size(); i++) {			
			DtoSale aux = convertOutDtoSale(sales.get(i));
			outputList.add(aux);
		}
		return outputList;
	}
	
	public DtoSale convertOutDtoSale(Sale sale) {
		DtoSale aux = new DtoSale();
		aux.setId(sale.getId());
		aux.setSaleDate(sale.getSaleDate().toString());
		aux.setDish(sale.getDish().getdishName());
		aux.setClient(sale.getClient().getName() + " " + sale.getClient().getLastName());
		return aux;
	}
}
