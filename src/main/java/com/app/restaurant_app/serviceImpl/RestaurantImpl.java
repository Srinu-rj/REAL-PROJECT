package com.app.restaurant_app.serviceImpl;

import com.app.restaurant_app.Exception.RestaurantException;
import com.app.restaurant_app.RestaurantAppApplication;
import com.app.restaurant_app.dto.RestaurantDto;
import com.app.restaurant_app.model.Address;
import com.app.restaurant_app.model.Restaurant;
import com.app.restaurant_app.model.User;
import com.app.restaurant_app.repository.AddressRepository;
import com.app.restaurant_app.repository.RestaurantRepository;
import com.app.restaurant_app.repository.UserRepository;
import com.app.restaurant_app.request.CreateRestaurantRequest;
import com.app.restaurant_app.service.RestaurantService;
import com.app.restaurant_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final AddressRepository addressRepository;


    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest request, User user) {
        Address address = addressRepository.save(request.getAddress());

        Restaurant restaurant = new Restaurant();
        restaurant.setId(request.getId());
        restaurant.setOwner(user);
        restaurant.setName(request.getName());
        restaurant.setDescription(request.getDescription());
        restaurant.setCuisineType(request.getCuisineType());
        restaurant.setAddress(request.getAddress());
        restaurant.setContactInformation(request.getContactInformation());
        restaurant.setOpeningHours(request.getOpeningHours());

        restaurant.setImages(request.getImages());
        restaurant.setRegistrationDate(request.getRegistrationDate());

        Restaurant saveRestaurant = restaurantRepository.save(restaurant);
        return saveRestaurant;

    }


    @Override
    public Restaurant updateRestaurant(Long id, CreateRestaurantRequest request) throws RestaurantException {
        Restaurant restaurant = findRestaurantById(id);
        //here updateRestaurant only update 2 filed
        if (restaurant.getCuisineType() != null) {
            restaurant.setCuisineType(request.getCuisineType());
        }
        if (restaurant.getDescription() != null) {
            restaurant.setDescription(request.getDescription());
        }
        return restaurantRepository.save(restaurant);

    }

    //logic build with Optional
    @Override
    public void deleteRestaurant(Long restaurantId) throws RestaurantException {
        Optional<Restaurant> restaurant = Optional.ofNullable(findRestaurantById(restaurantId));
        if (restaurant.isPresent()) {
            restaurantRepository.deleteById(restaurantId);
        } else {
            throw new RestaurantException("Not Found");
        }

    }


    //todo imp to learn logic
    @Override
    public Restaurant updateRestaurantStatus(Long id) throws RestaurantException {
        Restaurant restaurant = findRestaurantById(id);
        //TODO if restaurant is open it will false ,, is close true
        restaurant.setOpen(!restaurant.isOpen());
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurantsByUserId(Long id) {
        //todo custom method
        return restaurantRepository.findByOwnerId(id);
    }

    //TODO  RESTAURANT SERVICE
    //TODO CUSTOM METHODS
    @Override
    public List<Restaurant> searchRestaurant(String keyword) {
        //todo custom method are create by @Query -> caseIgnore in RestaurantRepository
        return restaurantRepository.searchQuary(keyword);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }


    //TODO IMP METHOD THAT CAN BE USE IN ALL APIS
    @Override
    public Restaurant findRestaurantById(Long id) throws RestaurantException {
        //todo Optional
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);

        if (restaurant.isPresent()) {
            return restaurant.get();
        } else {
            throw new RestaurantException("Restaurant with id " + id + "not found");
        }
    }

    @Override
    public RestaurantDto addToFavorites(Long id, User user) {
        return null;
    }


}