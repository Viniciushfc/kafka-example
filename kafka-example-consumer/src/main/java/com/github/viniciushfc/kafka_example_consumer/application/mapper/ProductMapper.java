package com.github.viniciushfc.kafka_example_consumer.application.mapper;

import com.github.viniciushfc.kafka_example_consumer.application.domain.dto.ProductRecordDTO;
import com.github.viniciushfc.kafka_example_consumer.application.domain.entity.Product;

public class ProductMapper {

    public static ProductRecordDTO toDTO(Product product) {
        if (product == null) return null;
        return new ProductRecordDTO(
                product.getId(),
                product.getName(),
                product.getQuantity(),
                product.getPrice()
        );
    }

    public static Product toEntity(ProductRecordDTO dto) {
        if (dto == null) return null;
        Product product = new Product();
        product.setId(dto.id());
        product.setName(dto.name());
        product.setQuantity(dto.quatity());
        product.setPrice(dto.price());
        return product;
    }
}
