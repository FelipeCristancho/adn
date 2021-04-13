package com.ceiba.adn.aplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.adn.domain.model.Dish;
import com.ceiba.adn.domain.port.repository.DishRepository;
import com.ceiba.adn.domain.service.sale.ShowDishMostSale;

@Service
public class DishService {
	
	@Autowired
	private DishRepository dishRepository;
	
	@Autowired
	private ShowDishMostSale showDishMostSale;
	
	
	public List<Dish> listDishes(){
		return dishRepository.findAll();
	}
	
	public Dish showDishMostSale() {
		long dishId = showDishMostSale.getMostSale();
		return dishRepository.findById(dishId).get();
	}
}
