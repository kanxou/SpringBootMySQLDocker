package com.example.springbootmysqldocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class SampleProductController {

    private final SampleProductService sampleProductService;

    @Autowired
    public SampleProductController(SampleProductService sampleProductService) {
        this.sampleProductService = sampleProductService;
    }

    @GetMapping
    public List<SampleProduct> getAllProducts() {
        return sampleProductService.getAllProducts();
    }

    @GetMapping("/{id}")
    public SampleProduct getProductById(@PathVariable Long id) {
        return sampleProductService.getProductById(id);
    }

    @PostMapping
    public SampleProduct createProduct(@RequestBody SampleProduct product) {
        return sampleProductService.createProduct(product);
    }

    @PutMapping("/{id}")
    public SampleProduct updateProduct(@PathVariable Long id, @RequestBody SampleProduct product) {
        product.setId(id);  // Set ID to ensure update for the correct product
        return sampleProductService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        sampleProductService.deleteProduct(id);
    }
}
