package com.app.restaurant_app.controller;

import com.app.restaurant_app.Exception.RestaurantException;
import com.app.restaurant_app.Exception.UserException;
import com.app.restaurant_app.model.Food;
import com.app.restaurant_app.model.Restaurant;
import com.app.restaurant_app.model.User;
import com.app.restaurant_app.request.CreateFoodRequest;
import com.app.restaurant_app.response.ApiResponse;
import com.app.restaurant_app.service.FoodService;
import com.app.restaurant_app.service.RestaurantService;
import com.app.restaurant_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
@RequiredArgsConstructor
public class AdminFoodController {

//    @RequestHeader("Authorization") String jwt

    /* TODO
        createFood
        updateFoodAvaibilityStatus
        deleteFood        */

    private final FoodService foodService;
    private final UserService userService;
    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestHeader("Authorization") String jwt,
                                           @RequestBody CreateFoodRequest request) throws UserException, RestaurantException {

        //todo find the  token
        User user = userService.findUserProfileByJwt(jwt);
        //todo if you order food then you get restaurantId must
        Restaurant restaurant = restaurantService.findRestaurantById(request.getRestaurantId());
        //
        Food food = foodService.createFood(request, request.getCategory(), restaurant);
        return new ResponseEntity<>(food, HttpStatus.CREATED);

    }

    //if any delete api retun type ApiResponse
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteFoodAdmin(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws UserException {
        //TODO FIND THE TOKEN THE DELETE THE ID
        User user = userService.findUserProfileByJwt(jwt);
        foodService.deleteFoodAdmin(id);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("food deleted success");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFoodAvaibilityStatus(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws UserException {
        //TODO FIND THE TOKEN
        User user = userService.findUserProfileByJwt(jwt);
        Food food = foodService.updateFoodAvaibilityStatus(id, user);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }


}
