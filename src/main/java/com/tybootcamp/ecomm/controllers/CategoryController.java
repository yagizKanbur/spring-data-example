package com.tybootcamp.ecomm.controllers;

import com.tybootcamp.ecomm.entities.Category;
import com.tybootcamp.ecomm.repositories.CategoryRepository;
import com.tybootcamp.ecomm.services.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {this.categoryService = categoryService;}


    @GetMapping(path = "/")
    public ResponseEntity<?> getCategoryByName(String name) {
        if(StringUtils.isBlank(name)){
            return categoryService.getAllCategories();
        }
        return  categoryService.getCategoryByName(name);
    }

    @PostMapping(path = "/")
    public ResponseEntity<?> addNewCategory(String name) {
        if(StringUtils.isBlank(name)){
            return new ResponseEntity<>("Name field cannot be null or empty", HttpStatus.BAD_REQUEST);
        }
        return categoryService.addNewCategory(name);
    }

   @PutMapping(path = "/")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category) {
        if (category == null) {
            return new ResponseEntity<>("Your request is null!", HttpStatus.BAD_REQUEST);
        }
        Boolean updateStatus = categoryService.updateCategory(category);

        if(updateStatus.equals(true)){
            return new ResponseEntity<>("The category updated", HttpStatus.OK);
        }
       return new ResponseEntity<>("This category does not exists", HttpStatus.NOT_FOUND);
    }
}
