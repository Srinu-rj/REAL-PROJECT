package com.app.restaurant_app.controller;

import com.app.restaurant_app.Exception.FoodException;
import com.app.restaurant_app.Exception.UserException;
import com.app.restaurant_app.model.Food;
import com.app.restaurant_app.model.User;
import com.app.restaurant_app.response.ApiResponse;
import com.app.restaurant_app.service.FoodService;
import com.app.restaurant_app.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
@RequiredArgsConstructor
public class FoodController {
// todo    @RequestHeader("Authorization") String jwt

    /*todo searchFood,
           getRestaurantFood,
           deleteFood
    */


    private final FoodService foodService;
    private final UserService userService;

    //todo in this apis only for searchFood-> getRestaurantFood
    //todo here one thing we get list of items evaray API
    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestHeader("Authorization") String jwt,
                                                 @RequestBody String name) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        List<Food> foodList = foodService.searchFood(name, user);
        return new ResponseEntity<>(foodList, HttpStatus.CREATED);

    }


    @GetMapping("/search/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantFood(@RequestParam boolean vegitairean,
                                                        @RequestParam boolean seasonal,
                                                        @RequestParam boolean nonVeg,
                                                        @RequestParam(required = false) String food_catagory,
                                                        @PathVariable Long restaurantId,
                                                        @RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        List<Food> food = foodService.getRestaurantFood(restaurantId, vegitairean, nonVeg, seasonal, food_catagory, user);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<Food> findFood(@PathVariable Long foodId, @RequestHeader("Authorization") String jwt) throws UserException, FoodException {
        User user = userService.findUserProfileByJwt(jwt);
        Food food = foodService.findById(foodId);
        return new ResponseEntity<>(food, HttpStatus.CREATED);

    }


}