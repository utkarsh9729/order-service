package com.ecom.order.mapper;

import com.ecom.order.dto.OrderDTO;
import com.ecom.order.dto.OrderLineDTO;
import com.ecom.order.model.Order;
import com.ecom.order.model.OrderLineItems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderLineItemsMapper {

    OrderLineItemsMapper INSTANCE = Mappers.getMapper( OrderLineItemsMapper.class );

    @Mapping(source = "skuCode", target = "skuCode")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "quantity", target = "quantity")
    public OrderLineDTO orderLineItemsToOrderLineDTO(OrderLineItems orderLineItems);
}
