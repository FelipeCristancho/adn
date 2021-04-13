package com.ceiba.adn.domain.service.client;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ceiba.adn.domain.model.Client;
import com.ceiba.adn.domain.port.repository.ClientRepository;

@Service
@Transactional
public class CreateClient {
	
	//En el paquete com.ceiba.adm.domain.service.... va toda la lógica de validaciones
	
	@Autowired
	ClientRepository clientRepository;
	
	private String messageOk = "Cliente creado correctamente";
	private String messageBad = "El cliente con el numero de cedula especificado ya existe";
	
	public ResponseEntity<Client> save(Client client) {
		if(!clientRepository.existsById(client.getIdentification())) {
			clientRepository.save(client);
			return new ResponseEntity(messageOk, HttpStatus.OK);
		}
		return new ResponseEntity(messageBad,HttpStatus.BAD_REQUEST);
	}
	
}
