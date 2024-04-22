package com.example.springbootmysqldocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleProductService {

    private final SampleProductRepository sampleProductRepository;

    @Autowired
    public SampleProductService(SampleProductRepository sampleProductRepository) {
        this.sampleProductRepository = sampleProductRepository;
    }

    public List<SampleProduct> getAllProducts() {
        return sampleProductRepository.findAll();
    }

    public SampleProduct getProductById(Long id) {
        return sampleProductRepository.findById(id).orElse(null);
    }

    public SampleProduct createProduct(SampleProduct product) {
        return sampleProductRepository.save(product);
    }

    public SampleProduct updateProduct(SampleProduct product) {
        if (!sampleProductRepository.existsById(product.getId())) {
            throw new RuntimeException("Product with ID " + product.getId() + " not found");
        }
        return sampleProductRepository.save(product);
    }

    public void deleteProduct(Long id) {
        sampleProductRepository.deleteById(id);
    }
}
