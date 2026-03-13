package com.github.viniciushfc.kafka_example_consumer.application.domain.entity;

import com.github.viniciushfc.kafka_example_consumer.application.domain.enums.EnumStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "orders")
public class Order {

    @Id
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product")
    private Product product;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

    @Column(name = "totalprice")
    private BigDecimal totalprice;
}
