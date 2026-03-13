package com.github.viniciushfc.kafka_example_consumer.application.service.impl;

import com.github.viniciushfc.kafka_example_consumer.application.domain.dto.KafkaProducerOrderRecordDTO;
import com.github.viniciushfc.kafka_example_consumer.application.domain.entity.Order;
import com.github.viniciushfc.kafka_example_consumer.application.domain.enums.EnumStatus;
import com.github.viniciushfc.kafka_example_consumer.application.mapper.OrderMapper;
import com.github.viniciushfc.kafka_example_consumer.application.repository.IOrderRepository;
import com.github.viniciushfc.kafka_example_consumer.application.service.contract.IOrderService;
import com.github.viniciushfc.kafka_example_consumer.application.service.contract.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final IProductService iProductService;

    @Override
    @Transactional
    public void resolveOrderProducer(KafkaProducerOrderRecordDTO dto) {
        BigDecimal totalPrice = iProductService.calculateTotalPrice(dto.product().quatity(), dto.product().price());

        Order order = OrderMapper.toEntity(dto, EnumStatus.PAGO, totalPrice);

        orderRepository.saveAndFlush(order);
        order = orderRepository.findById(order.getId()).orElse(null);

        System.out.println("Order has been resolved: " + order.toString());
    }
}
