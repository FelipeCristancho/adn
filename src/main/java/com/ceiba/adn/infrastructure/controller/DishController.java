package com.ceiba.adn.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.aplication.service.DishService;
import com.ceiba.adn.domain.model.Dish;

@RestController
@RequestMapping("/api/dish")
@CrossOrigin(origins = "*")
public class DishController {

	@Autowired
	DishService dishService;
	
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<Dish>> listDishes(){
		List<Dish> listDishes = dishService.listDishes();
		return new ResponseEntity<List<Dish>>(listDishes, HttpStatus.OK);
	}
	
	@GetMapping(value = "/mostSale")
	public Dish mostSale() {
		return dishService.showDishMostSale();
	}
}
