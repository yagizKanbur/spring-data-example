package com.tybootcamp.ecomm.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "shopping_basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    @OneToMany
    private Collection<BasketItem> basketItems = new ArrayList<>();

    public Basket(){

    }

    public Basket(Long id, Long customerId, Collection<BasketItem> basketItems) {
        this.id = id;
        this.customerId = customerId;
        this.basketItems = basketItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Collection<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(Collection<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }
}
