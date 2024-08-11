package com.app.restaurant_app.controller;


import com.app.restaurant_app.Exception.UserException;
import com.app.restaurant_app.model.Category;
import com.app.restaurant_app.model.User;
import com.app.restaurant_app.service.CategoryService;
import com.app.restaurant_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
@RequiredArgsConstructor
public class AdminCategoryController {

    // todo @RequestHeader("Authorization") String jwt

    private final UserService userService;
    private final CategoryService categoryService;

    @PostMapping("/admin/category")
    public ResponseEntity<Category> createCategory(@RequestHeader("Authorization") String jwt,
                                                   @RequestBody Category category) throws UserException {
        //todo Every api must be authenticated with token.
        User user = userService.findUserProfileByJwt(jwt);
        //TODO THIS REFERENCE WILL RETURN -> only it will take two files the api category name and user id
        Category createCategory = categoryService.asminCategory(category.getName(), user.getId());
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }

    //todo this api are get both admin ,customer
    @GetMapping("/category/restaurant")
    public ResponseEntity<List<Category>> getAdminFood(@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        List<Category> categories = categoryService.findCategoryByRestaurant(user.getId());
        return new ResponseEntity<>(categories, HttpStatus.CREATED);
    }


}
