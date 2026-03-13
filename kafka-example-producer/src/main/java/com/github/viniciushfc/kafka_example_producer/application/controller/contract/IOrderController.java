package com.github.viniciushfc.kafka_example_producer.application.controller.contract;

import com.github.viniciushfc.kafka_example_producer.application.dto.CreateOrderRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.dto.OrderRecordDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderController {

    ResponseEntity<List<OrderRecordDTO>> findAllOrders();

    ResponseEntity<OrderRecordDTO> createOrderForConsumer(CreateOrderRecordDTO dto);
}
