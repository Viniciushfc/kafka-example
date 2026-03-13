package com.github.viniciushfc.kafka_example_producer.application.mapper;

import com.github.viniciushfc.kafka_example_producer.application.domain.entity.Order;
import com.github.viniciushfc.kafka_example_producer.application.domain.enums.EnumStatus;
import com.github.viniciushfc.kafka_example_producer.application.dto.OrderRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.dto.ProductRecordDTO;

public class OrderMapper {

    public static OrderRecordDTO toDTO(Order order) {
        if (order == null) return null;
        return new OrderRecordDTO(
                order.getId(),
                ProductMapper.toDTO(order.getProduct()),
                order.getStatus()
        );
    }

    public static Order toEntity(OrderRecordDTO dto) {
        if (dto == null) return null;
        Order order = new Order();
        order.setId(dto.id());
        order.setProduct(ProductMapper.toEntity(dto.product()));
        order.setStatus(dto.status());
        return order;
    }

    public static Order toEntity(ProductRecordDTO productRecordDTO, EnumStatus status) {
        if (productRecordDTO == null) return null;
        Order order = new Order();
        order.setProduct(ProductMapper.toEntity(productRecordDTO));
        order.setStatus(status);
        return order;
    }
}

