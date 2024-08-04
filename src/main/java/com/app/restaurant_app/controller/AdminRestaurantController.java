package com.app.restaurant_app.controller;

import com.app.restaurant_app.Exception.RestaurantException;
import com.app.restaurant_app.Exception.UserException;
import com.app.restaurant_app.model.Restaurant;
import com.app.restaurant_app.model.User;
import com.app.restaurant_app.request.CreateRestaurantRequest;
import com.app.restaurant_app.response.ApiResponse;
import com.app.restaurant_app.service.RestaurantService;
import com.app.restaurant_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/restaurants")
@RequiredArgsConstructor
public class AdminRestaurantController {
    // TODO createRestaurant ,updateRestaurant ,deleteRestaurant ,updateStataurantStatus ,findRestaurantByUserId
    //@RequestHeader("Authorization") String jwt
    private final UserService userService;
    private final RestaurantService restaurantService;

    @PostMapping()
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody CreateRestaurantRequest request,
                                                       @RequestHeader("Authorization") String jwt) throws UserException {
        //TODO IF ANY API MUST BE FAST ->FIND USER BY TOKEN
        User user = userService.findUserProfileByJwt(jwt);
        Restaurant restaurant = restaurantService.createRestaurant(request, user);
        return new ResponseEntity<>(restaurant,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody CreateRestaurantRequest request,
                                                       @PathVariable Long id, @RequestHeader("Authorization") String jwt) throws UserException, RestaurantException {
        User user = userService.findUserProfileByJwt(jwt);
        Restaurant restaurant = restaurantService.updateRestaurant(id,request);
        return new ResponseEntity<>(restaurant,HttpStatus.CREATED);

    }

    //todo delete mapping can -> ApiResponse that will return
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteRestaurant(@PathVariable Long restaurantId,
                                                        @RequestHeader("Authorization") String jwt) throws UserException, RestaurantException {
        User user = userService.findUserProfileByJwt(jwt);

        restaurantService.deleteRestaurant(restaurantId);

        ApiResponse apiResponse = new ApiResponse("deleted success", true);
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<Restaurant> updateStataurantStatus(@PathVariable Long id,
                                                             @RequestHeader("Authorization") String jwt) throws RestaurantException {
        //todo t think no need  findUserProfileByJwt
        //todo it will used in RestaurantController
        Restaurant restaurant = restaurantService.updateRestaurantStatus(id);
        return new ResponseEntity<>(restaurant,HttpStatus.ACCEPTED);
    }

    //TODO THIS API ONLY GET USERS IN RESTAURANT
    //todo custom method that override in repository
    @GetMapping("/find/user")
    public ResponseEntity<Restaurant> findRestaurantsByUserId(@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        Restaurant restaurant = restaurantService.getRestaurantsByUserId(user.getId());
        //TODO RETURN THE USER ID
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

}
