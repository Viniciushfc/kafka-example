package com.github.viniciushfc.kafka_example_producer.application.service.impl;

import com.github.viniciushfc.kafka_example_producer.application.domain.entity.Product;
import com.github.viniciushfc.kafka_example_producer.application.dto.CreateProductRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.dto.ProductRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.mapper.ProductMapper;
import com.github.viniciushfc.kafka_example_producer.application.repository.IProductRepository;
import com.github.viniciushfc.kafka_example_producer.application.service.contract.IProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public ProductRecordDTO createProduct(CreateProductRecordDTO dto) {
        Product product = ProductMapper.toEntity(dto);

        return ProductMapper.toDTO(productRepository.save(product));
    }

    @Override
    public ProductRecordDTO findById(UUID idProduct) {
        return ProductMapper.toDTO(productRepository.findById(idProduct).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public ProductRecordDTO returnRandomProductId() {
        List<UUID> ids = productRepository.findAllIds();
        if (ids.isEmpty()) return null;

        UUID randomId = ids.get(new Random().nextInt(ids.size()));

        return findById(randomId);
    }
}
