package com.github.viniciushfc.kafka_example_consumer.application.kafkaListeners;

import com.github.viniciushfc.kafka_example_consumer.application.domain.dto.KafkaProducerOrderRecordDTO;
import com.github.viniciushfc.kafka_example_consumer.application.service.contract.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaOrderListener {

    private final IOrderService iOrderService;

    @KafkaListener(topics = "pedidos-topic", groupId = "pedidos-group")
    public void consume(KafkaProducerOrderRecordDTO dto) {
        iOrderService.resolveOrderProducer(dto);
    }
}
