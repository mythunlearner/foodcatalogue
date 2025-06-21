package com.foodapp.foodcatalogue.dto;

import java.util.List;

import com.foodapp.foodcatalogue.entity.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {
	private List<FoodItem> foodItemList;
	private Restaurant restaurant;

}
