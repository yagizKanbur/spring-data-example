package com.tybootcamp.ecomm.repositories;

import com.tybootcamp.ecomm.entities.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<BasketItem,Long> {
}
