package com.foodapp.foodcatalogue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.foodcatalogue.dto.FoodItemDTO;
import com.foodapp.foodcatalogue.entity.FoodItem;
import com.foodapp.foodcatalogue.mapper.FoodCatalogueMapper;
import com.foodapp.foodcatalogue.repo.FoodItemRepo;

@Service
public class FoodCatalogueService {
	@Autowired
	FoodItemRepo foodItemRepo;
	
	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		FoodItem foodItem =  foodItemRepo.save(FoodCatalogueMapper.INSTANCE.mapFoodItemDTOtoFoodItem(foodItemDTO));
		return FoodCatalogueMapper.INSTANCE.mapFoodItemtoFoodItemDTO(foodItem);
		
	}

}
