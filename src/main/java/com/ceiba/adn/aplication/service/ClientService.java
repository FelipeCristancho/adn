package com.ceiba.adn.aplication.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ceiba.adn.domain.dto.DtoSale;
import com.ceiba.adn.domain.model.Client;
import com.ceiba.adn.domain.port.repository.ClientRepository;
import com.ceiba.adn.domain.service.client.CreateClient;
import com.ceiba.adn.domain.service.client.ShowBestClient;
import com.ceiba.adn.domain.service.client.ShowSales;

@Service
@Transactional
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ShowSales showSales;
	
	@Autowired
	CreateClient createClient;
	
	@Autowired
	ShowBestClient showBestClient;
	
	public ResponseEntity<Client> save(Client client) {
		return createClient.save(client);
	}
	
	public List<Client> listClients(){
		return clientRepository.findAll();
	}
	
	public List<DtoSale> listSaleByClient(Client client){
		return showSales.convertOutputSales(client);
	}
	
	public Client showBesClient() {
		long document = showBestClient.getDocumentBestClient();
		return clientRepository.findById(document).get();
	}
	
}
