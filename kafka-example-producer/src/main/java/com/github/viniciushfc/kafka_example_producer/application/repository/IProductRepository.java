package com.github.viniciushfc.kafka_example_producer.application.repository;

import com.github.viniciushfc.kafka_example_producer.application.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {

    @Query("SELECT p.id FROM Product p")
    List<UUID> findAllIds();

}
