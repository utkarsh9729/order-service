package com.ecom.order.dto;

import lombok.*;

import java.math.BigDecimal;

public class OrderLineDTO {

    private String id;

    private String skuCode;

    private BigDecimal price;

    private BigDecimal quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public OrderLineDTO(String id, String skuCode, BigDecimal price, BigDecimal quantity) {
        this.id = id;
        this.skuCode = skuCode;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderLineDTO() {
    }
}
