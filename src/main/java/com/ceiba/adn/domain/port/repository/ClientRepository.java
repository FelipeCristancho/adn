package com.ceiba.adn.domain.port.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adn.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
