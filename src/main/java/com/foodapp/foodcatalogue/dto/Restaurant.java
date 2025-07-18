package com.foodapp.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
	private int id;
	private String address;
	private String city;
	private String name;
	private String restaurantDescription;
}
