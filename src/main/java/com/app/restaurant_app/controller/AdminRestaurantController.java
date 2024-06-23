//package com.app.restaurant_app.controller;
//
//import com.app.restaurant_app.Exception.RestaurantException;
//import com.app.restaurant_app.Exception.UserException;
//import com.app.restaurant_app.model.Restaurant;
//import com.app.restaurant_app.model.User;
//import com.app.restaurant_app.request.CreateRestaurantRequest;
//import com.app.restaurant_app.response.ApiResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/admin/restaurants")
//@RequiredArgsConstructor
//public class AdminRestaurantController {
//
//    private final RestaurantService restaurantService;
//    private final UserService userService;
//
//    @PostMapping()
//    public ResponseEntity<Restaurant> createRestaurant(
//            @RequestBody CreateRestaurantRequest req,
//            @RequestHeader("Authorization") String jwt) throws UserException {
//
//        User user = userService.findUserProfileByJwt(jwt);
//
//        System.out.println("----TRUE___-----" + jwt);
//        Restaurant restaurant = restaurantService.createRestaurant(req, user);
//        return ResponseEntity.ok(restaurant);
//    }
//
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody CreateRestaurantRequest req,
//                                                       @RequestHeader("Authorization") String jwt) throws RestaurantException, UserException {
//        User user = userService.findUserProfileByJwt(jwt);
//
//        Restaurant restaurant = restaurantService.updateRestaurant(id, req);
//        return ResponseEntity.ok(restaurant);
//
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<ApiResponse> deleteRestaurantById(@PathVariable("id") Long restaurantId,
//                                                            @RequestHeader("Authorization") String jwt) throws RestaurantException, UserException {
//        User user = userService.findUserProfileByJwt(jwt);
//
//        restaurantService.deleteRestaurant(restaurantId);
//
//        ApiResponse res = new ApiResponse("Restaurant Deleted with id Successfully", true);
//        return ResponseEntity.ok(res);
//    }
//
//
//    @PutMapping("/{id}/status")
//    public ResponseEntity<Restaurant> updateStataurantStatus(
//            @RequestHeader("Authorization") String jwt,
//            @PathVariable Long id) throws RestaurantException, UserException {
//
//        Restaurant restaurant = restaurantService.updateRestaurantStatus(id);
//        return ResponseEntity.ok(restaurant);
//
//    }
//
//    @GetMapping("/user")
//    public ResponseEntity<Restaurant> findRestaurantByUserId(
//            @RequestHeader("Authorization") String jwt) throws RestaurantException, UserException {
//        User user = userService.findUserProfileByJwt(jwt);
//        Restaurant restaurant = restaurantService.getRestaurantsByUserId(user.getId());
//        return ResponseEntity.ok(restaurant);
//
//    }
//
//
//}
