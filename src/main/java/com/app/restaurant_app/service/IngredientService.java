package com.app.restaurant_app.service;

import com.app.restaurant_app.model.IngredientCategory;
import com.app.restaurant_app.model.IngredientsItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IngredientService {
    IngredientCategory createCategoryIngredient(String name, Long restaurantId);

    List<IngredientCategory> findIngredientsCategoryByRestaurant(Long id);

    IngredientsItem categoryIngredientItems(Long restaurantId, String name, Long ingredientCategoryId);

    List<IngredientsItem> findRestaurantIngredientsItem(Long id);

    IngredientsItem updateStokeAvailabilityItemsInRestaurant(Long id);
}
