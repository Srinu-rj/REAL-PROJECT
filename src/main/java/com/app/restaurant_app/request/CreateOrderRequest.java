package com.app.restaurant_app.request;

import com.app.restaurant_app.model.Address;
import lombok.Data;

@Data
public class CreateOrderRequest {
 
	private Long restaurantId;
	
	private Address deliveryAddress;
	
    
}
