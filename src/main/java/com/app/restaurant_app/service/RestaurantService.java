package com.app.restaurant_app.service;

import com.app.restaurant_app.Exception.RestaurantException;
import com.app.restaurant_app.dto.RestaurantDto;
import com.app.restaurant_app.model.Restaurant;
import com.app.restaurant_app.model.User;
import com.app.restaurant_app.request.CreateRestaurantRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
    //TODO ADMIN RESTAURANT CONTROLLER

    Restaurant createRestaurant(CreateRestaurantRequest request, User user);
    Restaurant updateRestaurant(Long id, CreateRestaurantRequest request) throws RestaurantException;
    void deleteRestaurant(Long restaurantId) throws RestaurantException;
    Restaurant updateRestaurantStatus(Long id) throws RestaurantException;
    Restaurant getRestaurantsByUserId(Long id);

    //TODO  RESTAURANT CONTROLLER
    List<Restaurant> searchRestaurant(String keyword);
    List<Restaurant> getAllRestaurant();
    Restaurant findRestaurantById(Long id) throws RestaurantException;
    RestaurantDto addToFavorites(Long id, User user);
}
