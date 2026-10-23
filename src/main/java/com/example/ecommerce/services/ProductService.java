package com.example.ecommerce.services;

import com.example.ecommerce.dto.ProductRequestDTO;
import com.example.ecommerce.dto.ProductResponseDTO;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public Page<ProductResponseDTO> findAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(product -> new ProductResponseDTO(product));
    }

    @Transactional(readOnly = true)
    public ProductResponseDTO findById(Long id) {
        Product product = productRepository.findById(id).get();
        return new ProductResponseDTO(product);
    }

    @Transactional
    public ProductResponseDTO insert(ProductRequestDTO requestDTO) {
        Product product = new Product(null, requestDTO.getNome(), requestDTO.getDescription(),
                requestDTO.getPrice(), requestDTO.getImgUrl());

        product = productRepository.save(product);

        return new ProductResponseDTO(product);
    }

    @Transactional
    public ProductResponseDTO update(Long id, ProductRequestDTO requestDTO) {
        Product productCurrent = productRepository.getReferenceById(id);
        updateData(productCurrent, requestDTO);
        productRepository.save(productCurrent);
        return new ProductResponseDTO(productCurrent);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    private void updateData(Product productCurrent, ProductRequestDTO requestDTO) {
        productCurrent.setName(requestDTO.getNome());
        productCurrent.setDescription(requestDTO.getDescription());
        productCurrent.setPrice(requestDTO.getPrice());
        productCurrent.setImgUrl(requestDTO.getImgUrl());
    }
}
