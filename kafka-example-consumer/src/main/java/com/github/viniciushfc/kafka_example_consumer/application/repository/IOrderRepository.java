package com.github.viniciushfc.kafka_example_consumer.application.repository;

import com.github.viniciushfc.kafka_example_consumer.application.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IOrderRepository extends JpaRepository<Order, UUID> {
}
