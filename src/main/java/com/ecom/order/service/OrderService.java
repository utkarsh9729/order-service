package com.ecom.order.service;


import com.ecom.order.dto.OrderDTO;
import com.ecom.order.dto.OrderLineDTO;
import com.ecom.order.mapper.OrderLineItemsMapper;
import com.ecom.order.mapper.OrderMapper;
import com.ecom.order.model.Order;
import com.ecom.order.model.OrderLineItems;
import com.ecom.order.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class OrderService {


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ObjectMapper objectMapper;

    public Optional<OrderDTO> saveOrder(Order order) {


        OrderDTO orderDTO = new OrderDTO();

        try {
            if (order.getOrderNumber().isEmpty()) {
                log.info("order Number is null");
            }
            orderRepository.save(order);
            List<OrderLineItems> orderLineItems = order.getOrderLineItemsList();
            List<OrderLineDTO> orderLineDTOList = orderLineItems.stream().map(this::mapToDto).collect(Collectors.toList());
            log.info(objectMapper.writeValueAsString(orderLineDTOList));
            log.info(objectMapper.writeValueAsString(orderLineItems));
            orderDTO.setOrderNumber(order.getOrderNumber());
            orderDTO.setId(order.getId());
            orderDTO.setOrderLineDTOList(orderLineDTOList);


        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return Optional.of(orderDTO);
    }

    public Optional<OrderDTO> getOrderDetails(String orderId){

        OrderDTO orderDTO = new OrderDTO();
        Order order = new Order();
        try{

         List<Order> orderList = orderRepository.findOrderByOrderId(orderId);
         if(orderList.size()>0)
          order = orderList.get(0);
            List<OrderLineItems> orderLineItems = order.getOrderLineItemsList();
            List<OrderLineDTO> orderLineDTOList = orderLineItems.stream().map(this::mapToDto).collect(Collectors.toList());
            orderDTO.setOrderNumber(order.getOrderNumber());
            orderDTO.setId(order.getId());
            orderDTO.setOrderLineDTOList(orderLineDTOList);

        }
        catch (Exception e){

        }
        return Optional.of(orderDTO);
    }

    private OrderLineDTO mapToDto(OrderLineItems orderLineItems) {
        OrderLineDTO orderLineDTO = new OrderLineDTO();
        orderLineDTO.setPrice(orderLineItems.getPrice());
        orderLineDTO.setQuantity(orderLineItems.getQuantity());
        orderLineDTO.setSkuCode(orderLineItems.getSkuCode());
        orderLineDTO.setId(orderLineItems.getId());
        return orderLineDTO;
    }


}
