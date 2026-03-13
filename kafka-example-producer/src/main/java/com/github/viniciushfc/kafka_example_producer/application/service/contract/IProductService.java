package com.github.viniciushfc.kafka_example_producer.application.service.contract;

import com.github.viniciushfc.kafka_example_producer.application.dto.CreateProductRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.dto.ProductRecordDTO;

import java.util.UUID;

public interface IProductService {

    ProductRecordDTO createProduct(CreateProductRecordDTO dto);

    ProductRecordDTO findById(UUID idProduct);

    ProductRecordDTO returnRandomProductId();

}
