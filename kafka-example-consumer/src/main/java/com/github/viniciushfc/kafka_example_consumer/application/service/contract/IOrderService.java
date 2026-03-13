package com.github.viniciushfc.kafka_example_consumer.application.service.contract;

import com.github.viniciushfc.kafka_example_consumer.application.domain.dto.KafkaProducerOrderRecordDTO;

public interface IOrderService {

    void resolveOrderProducer(KafkaProducerOrderRecordDTO dto);
}
