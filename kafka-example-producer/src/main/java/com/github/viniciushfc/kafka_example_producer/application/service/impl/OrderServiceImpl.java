package com.github.viniciushfc.kafka_example_producer.application.service.impl;

import com.github.viniciushfc.kafka_example_producer.application.domain.entity.Order;
import com.github.viniciushfc.kafka_example_producer.application.domain.enums.EnumStatus;
import com.github.viniciushfc.kafka_example_producer.application.dto.CreateOrderRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.dto.OrderRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.dto.ProductRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.mapper.OrderMapper;
import com.github.viniciushfc.kafka_example_producer.application.repository.IOrderRepository;
import com.github.viniciushfc.kafka_example_producer.application.service.contract.IOrderService;
import com.github.viniciushfc.kafka_example_producer.application.service.contract.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final IProductService iProductService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public List<OrderRecordDTO> findAllOrders() {
        return orderRepository.findAll().stream().map(OrderMapper::toDTO).toList();
    }

    @Override
    public OrderRecordDTO createOrderForConsumer(CreateOrderRecordDTO dto) {
        ProductRecordDTO productRecordDTO = iProductService.findById(dto.idProduct());

        Order order = OrderMapper.toEntity(productRecordDTO, EnumStatus.AGUARDANDO_PAGAMENTO);
        OrderRecordDTO orderSavedDTO = OrderMapper.toDTO(orderRepository.save(order));
        kafkaTemplate.send("pedidos-topic", orderSavedDTO);

        return orderSavedDTO;
    }
}
