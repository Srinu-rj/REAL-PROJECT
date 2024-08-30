package com.app.restaurant_app.service;

import com.app.restaurant_app.Exception.FoodException;
import com.app.restaurant_app.model.Category;
import com.app.restaurant_app.model.Food;
import com.app.restaurant_app.model.Restaurant;
import com.app.restaurant_app.model.User;
import com.app.restaurant_app.request.CreateFoodRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {
    //todo ADMIN FOOD CONTROLLER
    Food createFood(CreateFoodRequest request, Category category, Restaurant restaurant);
    Food updateFoodAvaibilityStatus(Long id, User user);
    void deleteFoodAdmin(Long id);

    //todo FOOD CONTROLLER
    List<Food> searchFood(String name, User user);
    List<Food> getRestaurantFood(Long restaurantId, boolean vegitairean, boolean nonVeg, boolean seasonal, String foodCatagory, User user);
    Food findById(Long foodId) throws FoodException;

}
