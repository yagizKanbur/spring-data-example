package com.tybootcamp.ecomm.controllers;

import com.tybootcamp.ecomm.entities.BasketItem;
import com.tybootcamp.ecomm.entities.Customer;
import com.tybootcamp.ecomm.repositories.ProductJpaRepository;
import com.tybootcamp.ecomm.services.BasketService;
import com.tybootcamp.ecomm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/basket")
public class BasketController {
    // Add Product to Basket
    private final BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService){
        this.basketService = basketService;
    }

    @PostMapping("/")
    public ResponseEntity<BasketItem> addToBasket(BasketItem basketItem){
        BasketItem createdBasketItem = new BasketItem(basketItem.getUserId(), basketItem.getProductId(), basketItem.getProduct(), basketItem.getProductQuantity());
        createdBasketItem = basketService.addNewBasketItem(createdBasketItem);
        return new ResponseEntity<>(createdBasketItem, HttpStatus.OK);
    }


}
