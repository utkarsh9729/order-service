package com.ecom.order.controller;

import com.ecom.order.dto.OrderDTO;
import com.ecom.order.model.Order;
import com.ecom.order.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> saveOrderRequest(@RequestBody Order order) throws JsonProcessingException {

        log.info("order received");
        ObjectMapper objectMapper = new ObjectMapper();
        log.info(objectMapper.writeValueAsString(order));
        Optional<OrderDTO>  orderDTO = orderService.saveOrder(order);

        return new ResponseEntity<>(orderDTO.get(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderRequestDetails(@PathVariable String id){

        Optional<OrderDTO>  orderDTO = orderService.getOrderDetails(id);

        return new ResponseEntity<>(orderDTO.get(),HttpStatus.OK);
    }

}
