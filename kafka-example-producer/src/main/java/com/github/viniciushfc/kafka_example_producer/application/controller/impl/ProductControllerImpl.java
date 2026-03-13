package com.github.viniciushfc.kafka_example_producer.application.controller.impl;

import com.github.viniciushfc.kafka_example_producer.application.controller.contract.IProductController;
import com.github.viniciushfc.kafka_example_producer.application.dto.CreateProductRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.dto.ProductRecordDTO;
import com.github.viniciushfc.kafka_example_producer.application.service.contract.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/producer/product")
@RequiredArgsConstructor
public class ProductControllerImpl implements IProductController {

    private final IProductService iProductService;


    @PostMapping
    public ResponseEntity<ProductRecordDTO> createProduct(@RequestBody CreateProductRecordDTO dto) {
        return new ResponseEntity<>(iProductService.createProduct(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<ProductRecordDTO> findById(@PathVariable UUID idProduct) {
        return new ResponseEntity<>(iProductService.findById(idProduct), HttpStatus.OK);
    }

    @GetMapping("/random")
    public ResponseEntity<ProductRecordDTO> returnRandomProductId() {
        return new ResponseEntity<>(iProductService.returnRandomProductId(), HttpStatus.OK);
    }
}
