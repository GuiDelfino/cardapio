package com.cardapio.menu_digital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cardapio.menu_digital.dto.ProductDTO;
import com.cardapio.menu_digital.entity.Product;
import com.cardapio.menu_digital.exception.ProductNotFoundException;
import com.cardapio.menu_digital.repository.ProductRepository;

@Service
public class ProductService {

    private ProductDTO toDTO(Product product) {
        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getImageUrl()
        );
    }

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDTO> findAll() {
        return repository.findAll()
            .stream()
            .map(this::toDTO)
            .toList();
    }

    public ProductDTO findById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return toDTO(product);
    }

    public ProductDTO save(Product product) {
        Product saved = repository.save(product);
        return toDTO(saved);
    }

    public ProductDTO update(Long id, Product product) {
        Product existing = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setImageUrl(product.getImageUrl());

        return toDTO(repository.save(existing));
    }

    public void delete(Long id) {
        Product existing = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        repository.delete(existing);
    }

}
