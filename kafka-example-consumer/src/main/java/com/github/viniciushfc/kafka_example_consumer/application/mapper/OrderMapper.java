package com.github.viniciushfc.kafka_example_consumer.application.mapper;

import com.github.viniciushfc.kafka_example_consumer.application.domain.dto.KafkaProducerOrderRecordDTO;
import com.github.viniciushfc.kafka_example_consumer.application.domain.dto.OrderRecordDTO;
import com.github.viniciushfc.kafka_example_consumer.application.domain.entity.Order;
import com.github.viniciushfc.kafka_example_consumer.application.domain.enums.EnumStatus;

import java.math.BigDecimal;

public class OrderMapper {

    public static OrderRecordDTO toDTO(Order order) {
        if (order == null) return null;
        return new OrderRecordDTO(
                order.getId(),
                ProductMapper.toDTO(order.getProduct()),
                order.getStatus(),
                order.getTotalprice()
        );
    }

    public static Order toEntity(KafkaProducerOrderRecordDTO dto, EnumStatus status, BigDecimal totalprice) {
        if (dto == null) return null;
        Order order = new Order();
        order.setId(dto.id());
        order.setProduct(ProductMapper.toEntity(dto.product()));
        order.setStatus(status);
        order.setTotalprice(totalprice);
        return order;
    }
}
