package com.tybootcamp.ecomm.services;


import com.tybootcamp.ecomm.entities.Category;
import com.tybootcamp.ecomm.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        List<Category> allCategories = categoryRepository.findAll();
        return allCategories;
    }

    public List<Category> getCategoryByName (String name){
        List <Category> categoryList = categoryRepository.findAllByName(name);
        return categoryList;
    }

    public Category addNewCategory(String name){
        Category createdCategory = new Category(name.trim());
        createdCategory = categoryRepository.save(createdCategory);
        return createdCategory;
    }

    public Boolean updateCategory(Category category){
        try {
            Category categoryEntity = categoryRepository.findById(category.getId()).orElseThrow(EntityNotFoundException::new);
            categoryEntity.setName(category.getName());
            categoryRepository.save(categoryEntity);
            return true;
        } catch (EntityNotFoundException e) {
           return false;
        }
    }
}
