package com.app.restaurant_app.serviceImpl;

import com.app.restaurant_app.model.Category;
import com.app.restaurant_app.repository.CategoryRepository;
import com.app.restaurant_app.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findCategoryByRestaurant(Long id) {

        return List.of();
    }

    @Override
    public Category createCategory(String name, Long id) {
        return null;
    }
}
