package com.github.viniciushfc.kafka_example_consumer.application.domain.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductRecordDTO(UUID id,
                               String name,
                               Integer quatity,
                               BigDecimal price) {
}
