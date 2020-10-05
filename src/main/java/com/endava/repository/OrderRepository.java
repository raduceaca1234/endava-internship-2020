package com.endava.repository;

import com.endava.model.ClientOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<ClientOrder,Integer> {

}
