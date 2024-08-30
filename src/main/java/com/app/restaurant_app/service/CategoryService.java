package com.app.restaurant_app.service;

import com.app.restaurant_app.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> findCategoryByRestaurant(Long id);

    Category createCategory(String name, Long id);
}
