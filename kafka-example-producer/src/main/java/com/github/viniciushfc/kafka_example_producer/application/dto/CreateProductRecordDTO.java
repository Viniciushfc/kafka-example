package com.github.viniciushfc.kafka_example_producer.application.dto;

import java.math.BigDecimal;

public record CreateProductRecordDTO(String name,
                                     Integer quatity,
                                     BigDecimal price) {
}
