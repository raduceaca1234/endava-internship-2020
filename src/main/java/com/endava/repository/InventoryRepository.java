package com.endava.repository;

import com.endava.model.InventoryProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface InventoryRepository extends CrudRepository<InventoryProduct, Integer> {

    @Transactional
    @Modifying
    void decreaseAmount(String name, int amount);

    InventoryProduct findByType(String type);

}
