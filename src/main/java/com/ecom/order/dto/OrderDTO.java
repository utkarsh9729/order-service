package com.ecom.order.dto;

import com.ecom.order.model.OrderLineItems;
import lombok.*;

import java.util.List;


public class OrderDTO {
    private String id;

    private List<OrderLineDTO> orderLineDTOList;
    private String orderNumber;


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

    public List<OrderLineDTO> getOrderLineDTOList() {
        return orderLineDTOList;
    }

    public void setOrderLineDTOList(List<OrderLineDTO> orderLineDTOList) {
        this.orderLineDTOList = orderLineDTOList;
    }

    public OrderDTO(String id, List<OrderLineDTO> orderLineDTOList, String orderNumber) {
        this.id = id;
        this.orderLineDTOList = orderLineDTOList;
        this.orderNumber = orderNumber;
    }

    public OrderDTO() {
    }
}
