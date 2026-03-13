package com.github.viniciushfc.kafka_example_producer.application.service.contract;

import com.github.viniciushfc.kafka_example_producer.application.dto.CreateOrderRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.dto.OrderRecordDTO;

import java.util.List;

public interface IOrderService {

    List<OrderRecordDTO> findAllOrders();

    OrderRecordDTO createOrderForConsumer(CreateOrderRecordDTO dto);
}
