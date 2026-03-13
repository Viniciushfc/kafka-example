package com.github.viniciushfc.kafka_example_consumer.application.domain.dto;

import com.github.viniciushfc.kafka_example_consumer.application.domain.enums.EnumStatus;

import java.util.UUID;

public record KafkaProducerOrderRecordDTO(UUID id,
                                          ProductRecordDTO product,
                                          EnumStatus status) {
}
