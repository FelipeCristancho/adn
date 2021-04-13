package com.ceiba.adn.domain.port.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adn.domain.model.Client;
import com.ceiba.adn.domain.model.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	List<Sale> findByClient(Client client);
}
