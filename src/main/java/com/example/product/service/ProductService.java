package com.example.product.service;

import com.example.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    private final List<Product> products = new CopyOnWriteArrayList<>();
    private final AtomicLong counter = new AtomicLong(0);

    public ProductService() {
        // Create default products with explicit IDs
        products.add(new Product(1L, "Laptop", "High performance laptop", 1500.0));
        products.add(new Product(2L, "Smartphone", "Latest model smartphone", 800.0));
        products.add(new Product(3L, "Headphones", "Noise-cancelling headphones", 200.0));
        products.add(new Product(4L, "Smartwatch", "Waterproof fitness tracker", 150.0));
        products.add(new Product(5L, "Gaming Mouse", "RGB lighted gaming mouse", 60.0));
        // Reset counter so new products created via API start from 26
        counter.set(5);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public Product createProduct(Product product) {
        product.setId(counter.incrementAndGet());
        products.add(product);
        return product;
    }

    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        return getProductById(id).map(existingProduct -> {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            return existingProduct;
        });
    }

    public boolean deleteProduct(Long id) {
        return products.removeIf(product -> product.getId().equals(id));
    }
}
