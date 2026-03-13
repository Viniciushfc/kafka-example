package com.github.viniciushfc.kafka_example_producer.application.mapper;

import com.github.viniciushfc.kafka_example_producer.application.domain.entity.Product;
import com.github.viniciushfc.kafka_example_producer.application.dto.CreateProductRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.dto.ProductRecordDTO;

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

    public static Product toEntity(CreateProductRecordDTO dto) {
        if (dto == null) return null;
        Product product = new Product();
        product.setName(dto.name());
        product.setQuantity(dto.quatity());
        product.setPrice(dto.price());
        return product;
    }
}
