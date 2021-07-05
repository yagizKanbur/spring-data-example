package com.tybootcamp.ecomm.services;

import com.tybootcamp.ecomm.entities.BasketItem;
import com.tybootcamp.ecomm.repositories.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    private final BasketRepository basketRepository;

    @Autowired
    public BasketService(BasketRepository basketRepository){
        this.basketRepository = basketRepository;
    }

    public  BasketItem addNewBasketItem(BasketItem basketItem){
        BasketItem createdItem = basketRepository.save(basketItem);
        return createdItem;
    }
}
