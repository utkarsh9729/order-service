package com.ecom.order.repository;

import com.ecom.order.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {

    @Query("select * from c WHERE c.orderId = @orderId")
    ArrayList<Order> findOrderByOrderId(String orderId);
}
