package com.github.viniciushfc.kafka_example_consumer.application.service.impl;

import com.github.viniciushfc.kafka_example_consumer.application.domain.dto.ProductRecordDTO;
import com.github.viniciushfc.kafka_example_consumer.application.domain.entity.Product;
import com.github.viniciushfc.kafka_example_consumer.application.mapper.ProductMapper;
import com.github.viniciushfc.kafka_example_consumer.application.repository.IProductRepository;
import com.github.viniciushfc.kafka_example_consumer.application.service.contract.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public BigDecimal calculateTotalPrice(Integer quantity, BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(quantity))
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public ProductRecordDTO createProduct(ProductRecordDTO productRecordDTO) {
        Product product = ProductMapper.toEntity(productRecordDTO);
        product = productRepository.save(product);

        return ProductMapper.toDTO(product);
    }
}
