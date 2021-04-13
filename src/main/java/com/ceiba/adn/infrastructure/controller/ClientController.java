package com.ceiba.adn.infrastructure.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.ceiba.adn.aplication.service.ClientService;
import com.ceiba.adn.domain.dto.DtoSale;
import com.ceiba.adn.domain.model.Client;
import com.ceiba.adn.domain.port.repository.ClientRepository;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	ClientRepository clientRepository;
	
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Client>> listClients(){
		List<Client> clients = clientService.listClients();
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}
	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> createClient(@RequestBody Client client){
		Client newClient = new Client(client.getIdentification(), client.getName(), client.getLastName(), client.getTelephone());
		return clientService.save(newClient);
	}
	
	@GetMapping(value = "/listSales/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DtoSale>> listSales(@PathVariable long id){
		Optional<Client> client = clientRepository.findById(id);
		List<DtoSale> sales = new ArrayList<>();
		if (client.isPresent()) {
			sales = clientService.listSaleByClient(client.get());			
		}
		return new ResponseEntity<List<DtoSale>>(sales, HttpStatus.OK);
	}
	
	@GetMapping(value = "/best")
	public Client getBestClient() {
		return clientService.showBesClient();
	}
}
