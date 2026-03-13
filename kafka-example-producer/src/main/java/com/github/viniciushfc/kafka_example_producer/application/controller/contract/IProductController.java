package com.github.viniciushfc.kafka_example_producer.application.controller.contract;

import com.github.viniciushfc.kafka_example_producer.application.dto.CreateProductRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.dto.ProductRecordDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IProductController {

    ResponseEntity<ProductRecordDTO> createProduct(CreateProductRecordDTO dto);

    ResponseEntity<ProductRecordDTO> findById(UUID idProduct);

    ResponseEntity<ProductRecordDTO> returnRandomProductId();
}
