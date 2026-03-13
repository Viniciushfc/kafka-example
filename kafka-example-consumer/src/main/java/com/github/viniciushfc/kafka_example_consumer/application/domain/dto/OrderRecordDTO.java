package com.github.viniciushfc.kafka_example_consumer.application.domain.dto;

import com.github.viniciushfc.kafka_example_consumer.application.domain.enums.EnumStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderRecordDTO (UUID id,
                              ProductRecordDTO product,
                              EnumStatus status,
                              BigDecimal totalPrice) {
}
