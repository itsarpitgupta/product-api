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
        // Create default products
        createProduct(new Product(null, "Laptop", "High performance laptop", 1500.0));
        createProduct(new Product(null, "Smartphone", "Latest model smartphone", 800.0));
        createProduct(new Product(null, "Headphones", "Noise-cancelling headphones", 200.0));
        createProduct(new Product(null, "Smartwatch", "Waterproof fitness tracker", 150.0));
        createProduct(new Product(null, "Gaming Mouse", "RGB lighted gaming mouse", 60.0));
        createProduct(new Product(null, "Keyboard", "Mechanical wireless keyboard", 120.0));
        createProduct(new Product(null, "Monitor", "27-inch 4K UHD monitor", 400.0));
        createProduct(new Product(null, "Tablet", "10-inch high resolution tablet", 350.0));
        createProduct(new Product(null, "Printer", "Wireless laser printer", 250.0));
        createProduct(new Product(null, "Webcam", "1080p HD streaming webcam", 90.0));
        createProduct(new Product(null, "Speakers", "2.1 Bluetooth sound system", 130.0));
        createProduct(new Product(null, "Microphone", "Studio quality USB microphone", 110.0));
        createProduct(new Product(null, "External SSD", "1TB portable NVMe SSD", 180.0));
        createProduct(new Product(null, "Router", "Wi-Fi 6 dual-band router", 120.0));
        createProduct(new Product(null, "Desk Lamp", "LED lamp with wireless charging", 45.0));
        createProduct(new Product(null, "Chair", "Ergonomic office chair", 220.0));
        createProduct(new Product(null, "Backpack", "Water-resistant laptop bag", 75.0));
        createProduct(new Product(null, "USB Hub", "7-in-1 USB-C adapter", 50.0));
        createProduct(new Product(null, "Power Bank", "20000mAh fast charge battery", 40.0));
        createProduct(new Product(null, "VR Headset", "All-in-one virtual reality system", 400.0));
        createProduct(new Product(null, "Test Product", "Test Product", 10000000.0));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> get
                rn products.stream()
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
