package com.app.restaurant_app.response;


import com.app.restaurant_app.enums.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {
	
	private String message;
	private String jwt;
	private USER_ROLE role;
	


}
