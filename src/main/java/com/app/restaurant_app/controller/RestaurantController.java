package com.app.restaurant_app.controller;

import com.app.restaurant_app.Exception.RestaurantException;
import com.app.restaurant_app.Exception.UserException;
import com.app.restaurant_app.dto.RestaurantDto;
import com.app.restaurant_app.model.Restaurant;
import com.app.restaurant_app.model.User;
import com.app.restaurant_app.service.RestaurantService;
import com.app.restaurant_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class RestaurantController {

    //    TODO -> THIS METHODS ARE IMPLED IN ->searchRestaurant , getRestaurantsByUserId , addToFavorites , getAllRestaurant
//    TODO in this all APIS GETMAPPINF
    private final UserService userService;
    private final RestaurantService restaurantService;

    //todo here the api
    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(@RequestParam String keyword,
                                                             @RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);

        List<Restaurant> restaurants = restaurantService.searchRestaurant(keyword);
//        return new ResponseEntity<>(restaurants, HttpStatus.CREATED);
        return ResponseEntity.ok(restaurants);

    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Restaurant>> findAllRestaurant(@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);

        List<Restaurant> restaurants = restaurantService.getAllRestaurant();

        return ResponseEntity.ok(restaurants);
    }

    //todo this apis are
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws UserException, RestaurantException {
        User user = userService.findUserProfileByJwt(jwt);
        Restaurant restaurant = restaurantService.findRestaurantById(id);
        return ResponseEntity.ok(restaurant);
    }

    //todo PUTMAPPING ->this api
    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestaurantDto> addToFavorites(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws UserException {

        //todo user get jwt token  that ref used restaurant
        User user = userService.findUserProfileByJwt(jwt);
        RestaurantDto restaurantDto = restaurantService.addToFavorites(id, user);
        return ResponseEntity.ok(restaurantDto);
    }


}
