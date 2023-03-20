package com.ecom.order.mapper;

import com.ecom.order.dto.OrderDTO;
import com.ecom.order.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper( OrderMapper.class );


    @Mapping(source = "orderNumber", target = "orderNumber")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "orderLineItemsList", target = "orderLineDTOList")
    public  OrderDTO orderToOrderDTO(Order order);
}
