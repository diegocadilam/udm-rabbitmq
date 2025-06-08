package br.com.cadilam.producer_service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadilam.producer_service.dtos.ProductDTO;
import br.com.cadilam.producer_service.services.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> produces(@RequestBody ProductDTO dto) {
        service.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
