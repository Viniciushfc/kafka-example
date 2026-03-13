package com.github.viniciushfc.kafka_example_producer.application.dto;

import com.github.viniciushfc.kafka_example_producer.application.domain.enums.EnumStatus;

import java.util.UUID;

public record OrderRecordDTO(UUID id,
                             ProductRecordDTO product,
                             EnumStatus status) {
}
