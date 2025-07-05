package com.foodapp.foodcatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.foodapp.foodcatalogue.dto.FoodCataloguePage;
import com.foodapp.foodcatalogue.dto.FoodItemDTO;
import com.foodapp.foodcatalogue.dto.Restaurant;
import com.foodapp.foodcatalogue.entity.FoodItem;
import com.foodapp.foodcatalogue.mapper.FoodCatalogueMapper;
import com.foodapp.foodcatalogue.repo.FoodItemRepo;

@Service
public class FoodCatalogueService {
	@Autowired
	FoodItemRepo foodItemRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		FoodItem foodItem =  foodItemRepo.save(FoodCatalogueMapper.INSTANCE.mapFoodItemDTOtoFoodItem(foodItemDTO));
		return FoodCatalogueMapper.INSTANCE.mapFoodItemtoFoodItemDTO(foodItem);
		
	}

	public FoodCataloguePage fetchFoodcataloguepageDetails(Integer restaurantId) {
		//Fetch Restaurant Details
		List<FoodItem> foodItemList = fetchFooditemList(restaurantId);
		//Fetch FoodCatalogue
		Restaurant restaurant = fetchRestaurantDetailsFromMs(restaurantId);
		FoodCataloguePage foodCataloguePage = createFoodCatalogue(foodItemList, restaurant);
		return foodCataloguePage;
	}

	
	private List<FoodItem> fetchFooditemList(Integer restaurantId){
		return foodItemRepo.findByRestaurantId(restaurantId);
		
	}
	
	private Restaurant fetchRestaurantDetailsFromMs(Integer restaurantId) {
		//This RestTemplate Calling the Restaurant MSA to fetch the restaurant Details
		return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, Restaurant.class);
		
	}
	
	private FoodCataloguePage createFoodCatalogue(List<FoodItem> foodItemList, Restaurant restaurant) {
		FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
		foodCataloguePage.setFoodItemList(foodItemList);
		foodCataloguePage.setRestaurant(restaurant);
		return foodCataloguePage;
	}
}
