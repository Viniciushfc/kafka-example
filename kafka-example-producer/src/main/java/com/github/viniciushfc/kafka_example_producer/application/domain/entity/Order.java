package com.github.viniciushfc.kafka_example_producer.application.domain.entity;

import com.github.viniciushfc.kafka_example_producer.application.domain.enums.EnumStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EnumStatus status;
}
