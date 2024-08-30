package com.app.restaurant_app.serviceImpl;

import com.app.restaurant_app.model.IngredientCategory;
import com.app.restaurant_app.model.IngredientsItem;
import com.app.restaurant_app.repository.IngredientsCategoryRepository;
import com.app.restaurant_app.repository.IngredientsItemRepository;
import com.app.restaurant_app.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientsCategoryRepository ingredientsCategoryRepository;
    private final IngredientsItemRepository ingredientsItemRepository;

    @Override
    public IngredientCategory createCategoryIngredient(String name, Long restaurantId) {

        return null;
    }

    @Override
    public List<IngredientCategory> findIngredientsCategoryByRestaurant(Long id) {
        return List.of();
    }

    @Override
    public IngredientsItem categoryIngredientItems(Long restaurantId, String name, Long ingredientCategoryId) {
        return null;
    }

    @Override
    public List<IngredientsItem> findRestaurantIngredientsItem(Long id) {
        return List.of();
    }

    @Override
    public IngredientsItem updateStokeAvailabilityItemsInRestaurant(Long id) {
        return null;
    }
}
