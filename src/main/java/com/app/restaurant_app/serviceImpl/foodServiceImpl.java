package com.app.restaurant_app.serviceImpl;

import com.app.restaurant_app.Exception.FoodException;
import com.app.restaurant_app.model.Category;
import com.app.restaurant_app.model.Food;
import com.app.restaurant_app.model.Restaurant;
import com.app.restaurant_app.model.User;
import com.app.restaurant_app.repository.FoodRepository;
import com.app.restaurant_app.request.CreateFoodRequest;
import com.app.restaurant_app.service.FoodService;
import com.app.restaurant_app.service.RestaurantService;
import com.app.restaurant_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class foodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final UserService userService;
    private final RestaurantService restaurantService;


    //todo ADMIN FOOD CONTROLLER
    @Override
    public Food createFood(CreateFoodRequest request, Category category, Restaurant restaurant) {

        Food food = new Food();
        //todo directly call category
        food.setFoodCategory(category);
        food.setName(request.getName());
        food.setDescription(request.getDescription());
        food.setImages(request.getImages());
        food.setAvailable(true);
        food.setCreationDate(new Date());
        food.setPrice(request.getPrice());
        food.setIngredients(request.getIngredients());
        //todo directly call restaurant
        food.setRestaurant(restaurant);
        //todo -> !request.isVegetarian()
        food.setVegetarian(request.isVegetarian());
        food.setSeasonal(request.isSeasonal());

        return foodRepository.save(food);
    }


    @Override
    public Food updateFoodAvaibilityStatus(Long id, User user) {
        return null;
    }


    //todo FOOD CONTROLLER

    @Override
    public List<Food> searchFood(String name, User user) {
        return List.of();
    }

    @Override
    public List<Food> getRestaurantFood(Long restaurantId, boolean vegitairean, boolean nonVeg, boolean seasonal, String foodCatagory, User user) {
        return List.of();
    }


    @Override
    public Food findById(Long foodId) throws FoodException {
        Optional<Food> food = foodRepository.findById(foodId);
        if (food.isEmpty()) {
            throw new FoodException("Not found");
        } else {
            return food.get();
        }
    }

    @Override
    public void deleteFoodAdmin(Long id) {

    }
}
