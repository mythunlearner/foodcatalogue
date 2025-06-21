package com.foodapp.foodcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodcatalogue.dto.FoodItemDTO;
import com.foodapp.foodcatalogue.service.FoodCatalogueService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/food")
public class FoodCatalogueController {
	@Autowired
	FoodCatalogueService foodCatalogueService;
	
	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
		FoodItemDTO foodItemDTO1 = foodCatalogueService.addFoodItem(foodItemDTO);
		return new ResponseEntity<>(foodItemDTO1, HttpStatus.OK);
	}
	

}
