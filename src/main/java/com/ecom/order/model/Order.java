package com.ecom.order.model;


import lombok.*;

import java.util.List;


public class Order {

    private String id;

    private String orderNumber;

    private List<OrderLineItems> orderLineItemsList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<OrderLineItems> getOrderLineItemsList() {
        return orderLineItemsList;
    }

    public void setOrderLineItemsList(List<OrderLineItems> orderLineItemsList) {
        this.orderLineItemsList = orderLineItemsList;
    }

    public Order(String id, String orderNumber, List<OrderLineItems> orderLineItemsList) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderLineItemsList = orderLineItemsList;
    }

    public Order() {
    }
}
