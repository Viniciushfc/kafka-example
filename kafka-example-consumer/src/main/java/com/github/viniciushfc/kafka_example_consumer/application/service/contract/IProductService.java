package com.github.viniciushfc.kafka_example_consumer.application.service.contract;

import com.github.viniciushfc.kafka_example_consumer.application.domain.dto.ProductRecordDTO;

import java.math.BigDecimal;

public interface IProductService {

    BigDecimal calculateTotalPrice(Integer quantity, BigDecimal price);

    ProductRecordDTO createProduct(ProductRecordDTO productRecordDTO);
}
