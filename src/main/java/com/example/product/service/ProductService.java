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
        products.add(new Product(6L, "Keyboard", "Mechanical wireless keyboard", 120.0));
        products.add(new Product(7L, "Monitor", "27-inch 4K UHD monitor", 400.0));
        products.add(new Product(8L, "Tablet", "10-inch high resolution tablet", 350.0));
        products.add(new Product(9L, "Printer", "Wireless laser printer", 250.0));
        products.add(new Product(10L, "Webcam", "1080p HD streaming webcam", 90.0));
        products.add(new Product(11L, "Speakers", "2.1 Bluetooth sound system", 130.0));
        products.add(new Product(12L, "Microphone", "Studio quality USB microphone", 110.0));
        products.add(new Product(13L, "External SSD", "1TB portable NVMe SSD", 180.0));
        products.add(new Product(14L, "Router", "Wi-Fi 6 dual-band router", 120.0));
        products.add(new Product(15L, "Desk Lamp", "LED lamp with wireless charging", 45.0));
        products.add(new Product(16L, "Chair", "Ergonomic office chair", 220.0));
        products.add(new Product(17L, "Backpack", "Water-resistant laptop bag", 75.0));
        products.add(new Product(18L, "USB Hub", "7-in-1 USB-C adapter", 50.0));
        products.add(new Product(19L, "Power Bank", "20000mAh fast charge battery", 40.0));
        products.add(new Product(20L, "VR Headset", "All-in-one virtual reality system", 400.0));
        // Reset counter so new products created via API start from 22
        counter.set(21);
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
