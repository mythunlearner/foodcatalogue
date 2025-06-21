package com.foodapp.foodcatalogue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.foodapp.foodcatalogue.dto.FoodItemDTO;
import com.foodapp.foodcatalogue.entity.FoodItem;

@Mapper
public interface FoodCatalogueMapper {
	FoodCatalogueMapper  INSTANCE = Mappers.getMapper(FoodCatalogueMapper.class);
	
	FoodItem mapFoodItemDTOtoFoodItem(FoodItemDTO foodItemDTO);
	FoodItemDTO mapFoodItemtoFoodItemDTO(FoodItem foodItem);

}
