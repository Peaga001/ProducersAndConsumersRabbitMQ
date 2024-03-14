package br.com.ph.producer.controllers;

import br.com.ph.producer.services.ProductService;
import dtos.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/products")

public class ProductController {
    private final ProductService $service;

    public ProductController(ProductService $service) {
        this.$service = $service;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> products(@RequestBody ProductDTO $dto)
    {
        $service.createProduct($dto);
        return ResponseEntity.status(CREATED).build();
    }
}
