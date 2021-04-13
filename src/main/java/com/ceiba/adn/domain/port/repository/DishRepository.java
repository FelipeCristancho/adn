package com.ceiba.adn.domain.port.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adn.domain.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long>{

}
