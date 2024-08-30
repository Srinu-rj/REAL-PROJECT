package com.app.restaurant_app.controller;


import com.app.restaurant_app.model.IngredientCategory;
import com.app.restaurant_app.model.IngredientsItem;
import com.app.restaurant_app.request.CreateIngredientCategoryRequest;
import com.app.restaurant_app.request.CreateIngredientRequest;
import com.app.restaurant_app.service.IngredientService;
import com.app.restaurant_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
@RequiredArgsConstructor
public class IngredientController {

    //    @RequestHeader("Authorization") String jwt,

    private final IngredientService ingredientService;


    @PostMapping("/create/ingredient")
    public ResponseEntity<IngredientCategory> categoryIngredient(@RequestBody CreateIngredientCategoryRequest request) {
        //todo here api call only ->getName ,getRestaurantId
        IngredientCategory category = ingredientService.createCategoryIngredient(request.getName(), request.getRestaurantId());
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{id}/category")
    public ResponseEntity<List<IngredientCategory>> getRestaurantIngredientsCategory(@PathVariable Long id) {
        List<IngredientCategory> categories = ingredientService.findIngredientsCategoryByRestaurant(id);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //TODO RESTAURANT WILL POST THE -> IngredientsItem
    @PostMapping("/ingredient/items")
    public ResponseEntity<IngredientsItem> categoryIngredientItems(@RequestBody CreateIngredientRequest request) {
        IngredientsItem item = ingredientService.categoryIngredientItems(request.getRestaurantId(), request.getName(), request.getIngredientCategoryId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    //TODO GET THE ALL ITEMS FROM CUSTOMER
    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<IngredientsItem>> getRestaurantIngredientsItem(@PathVariable Long id) {
        List<IngredientsItem> item = ingredientService.findRestaurantIngredientsItem(id);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    // todo  update  RestaurantIngredientsItem Their availability foodItems.
    @PutMapping("/{id}/stoke")
    public ResponseEntity<IngredientsItem> updateStoke(@PathVariable Long id) {
        IngredientsItem item = ingredientService.updateStokeAvailabilityItemsInRestaurant(id);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }


}
