package com.app.restaurant_app.request;

import lombok.Data;

@Data
public class UpdateCartItemRequest {
	
	private Long cartItemId;
	private int quantity;

}
