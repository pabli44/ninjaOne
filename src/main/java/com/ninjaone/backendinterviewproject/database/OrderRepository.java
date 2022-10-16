package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAll();
}
