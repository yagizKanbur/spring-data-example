package com.tybootcamp.ecomm.services;


import com.tybootcamp.ecomm.entities.Category;
import com.tybootcamp.ecomm.repositories.CategoryRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<?>getCategoryByName(String name){
        if(StringUtils.isBlank(name)){
            return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
        }
        List <Category> categoryList = categoryRepository.findAllByName(name);
        if (!categoryList.isEmpty()){
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        }
        return new ResponseEntity<>("There isn't any Category with name: " + name, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> addNewCategory(String name){
        if(StringUtils.isBlank(name)){
            return new ResponseEntity<>("Name field cannot be null or empty", HttpStatus.BAD_REQUEST);
        }
        Category createdCategory = new Category(name.trim());
        createdCategory = categoryRepository.save(createdCategory);
        return new ResponseEntity<>(createdCategory,HttpStatus.OK);
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
