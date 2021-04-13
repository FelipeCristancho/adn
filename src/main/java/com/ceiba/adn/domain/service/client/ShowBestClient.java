package com.ceiba.adn.domain.service.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.adn.domain.model.Sale;
import com.ceiba.adn.domain.port.repository.SaleRepository;
import com.ceiba.adn.domain.service.generalRules.MostRepeatedElement;

@Service
public class ShowBestClient {
	
	@Autowired
	SaleRepository saleRepository;
	
	@Autowired
	MostRepeatedElement mostRepeatedElement;
	
	public List<Long> listAllDocumentsOfClients() {
		List<Sale> sales = saleRepository.findAll();
		List<Long> listDocuments = new ArrayList<>();
		for (int i = 0; i < sales.size(); i++) {
			listDocuments.add(sales.get(i).getClient().getIdentification());
		}
		return listDocuments;
	}
	
	public long getDocumentBestClient() {
		List<Long> listDocuments = listAllDocumentsOfClients();
		return mostRepeatedElement.getMostRepeatedElement(listDocuments);
	}
	
}
