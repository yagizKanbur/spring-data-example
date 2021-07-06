package com.tybootcamp.ecomm.entities;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "basket_item")
public class BasketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "basket_id")
    private @NotBlank Long basketId;

    @Column(name ="product_id")
    private @NotBlank Long productId;

    private int productQuantity;

    public BasketItem(Long id, @NotBlank Long basketId, @NotBlank Long productId, int productQuantity) {
        this.id = id;
        this.basketId = basketId;
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public BasketItem(Long id, @NotBlank Long basketId, @NotBlank Long productId){
        this.id = id;
        this.basketId = basketId;
        this.productId = productId;
        this.productQuantity = 1; // Change here
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
