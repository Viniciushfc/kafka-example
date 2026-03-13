package com.github.viniciushfc.kafka_example_consumer.application.repository;

import com.github.viniciushfc.kafka_example_consumer.application.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {

}
