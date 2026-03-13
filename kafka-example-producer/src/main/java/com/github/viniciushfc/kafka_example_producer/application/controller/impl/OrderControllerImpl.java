package com.github.viniciushfc.kafka_example_producer.application.controller.impl;

import com.github.viniciushfc.kafka_example_producer.application.controller.contract.IOrderController;
import com.github.viniciushfc.kafka_example_producer.application.dto.CreateOrderRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.dto.OrderRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.service.contract.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/producer/order")
@RequiredArgsConstructor
public class OrderControllerImpl implements IOrderController {

    private final IOrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderRecordDTO>> findAllOrders() {
        return new ResponseEntity<>(orderService.findAllOrders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderRecordDTO> createOrderForConsumer(@RequestBody CreateOrderRecordDTO dto) {
        return new ResponseEntity<>(orderService.createOrderForConsumer(dto), HttpStatus.CREATED);
    }


}
