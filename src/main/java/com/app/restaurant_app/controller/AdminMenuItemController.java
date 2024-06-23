//package com.app.restaurant_app.controller;
//
//import com.app.restaurant_app.Exception.FoodException;
//import com.app.restaurant_app.Exception.RestaurantException;
//import com.app.restaurant_app.Exception.UserException;
//import com.app.restaurant_app.model.Food;
//import com.app.restaurant_app.model.Restaurant;
//import com.app.restaurant_app.model.User;
//import com.app.restaurant_app.request.CreateFoodRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/admin/food")
//@RequiredArgsConstructor
//public class AdminMenuItemController {
//
//
//	private final FoodService menuItemService;
//	private final UserService userService;
//	private final RestaurantService restaurantService;
//	private final CategoryService categoryService;
//
//	@PostMapping()
//	public ResponseEntity<Food> createItem(@RequestBody CreateFoodRequest item, @RequestHeader("Authorization") String jwt)throws FoodException, UserException, RestaurantException {
//		System.out.println("req-controller ----"+item);
//		User user = userService.findUserProfileByJwt(jwt);
////		Category category=categoryService.findCategoryById(item.getCategoryId());
//		Restaurant restaurant=restaurantService.findRestaurantById(item.getRestaurantId());
//			Food menuItem = menuItemService.createFood(item,item.getCategory(),restaurant);
//			return ResponseEntity.ok(menuItem);
//
//	}
//
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deleteItem(@PathVariable Long id, @RequestHeader("Authorization") String jwt)
//			throws UserException, FoodException {
//		//todo if any user want delete ItemId need Authorization
//		User user = userService.findUserProfileByJwt(jwt);
//
//			menuItemService.deleteFood(id);
//			//todo return type String
//			return ResponseEntity.ok("Menu item deleted");
//
//
//	}
//
//	@GetMapping("/search")
//	public ResponseEntity<List<Food>> getMenuItemByName(@RequestParam String name)  {
//		List<Food> menuItem = menuItemService.searchFood(name);
//		return ResponseEntity.ok(menuItem);
//	}
//
//
//	@PutMapping("/{id}")
//	public ResponseEntity<Food> updateAvilibilityStatus(
//			@PathVariable Long id) throws FoodException {
//		Food menuItems= menuItemService.updateAvailibilityStatus(id);
//		return ResponseEntity.ok(menuItems);
//	}
//
//
//
//}
