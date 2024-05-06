package com.qpassessment.groceryapp.service;

import com.qpassessment.groceryapp.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private List<Product> products = new ArrayList<>();
  private int nextId = 1;

  @CacheEvict(value = "products", allEntries = true)
  public Product addProduct(Product product) {
    product.setId(String.valueOf(nextId++));
    products.add(product);
    return product;
  }

  @CacheEvict(value = "products", allEntries = true)
  public boolean deleteProduct(String productId) {
    return products.removeIf(product -> product.getId().equals(productId));
  }

  @Cacheable(value = "products")
  public List<Product> getAllProducts() {
    return products;
  }

  @Cacheable(value = "products", key = "#productId")
  public Product getProductById(String productId) {
    return products.stream()
        .filter(product -> product.getId().equals(productId))
        .findFirst()
        .orElse(null);
  }

  @CacheEvict(value = "products", key = "#productId")
  public Product updateInventory(String productId, Integer quantity) {
    System.out.println(quantity);
    Product product = getProductById(productId);
    if (product != null) {
      product.setQuantity(product.getQuantity() + quantity);
      return product;
    } else {
      throw new IllegalArgumentException("Product not found.");
    }
  }

  @CacheEvict(value = "products", key = "#productId")
  public Product updateProduct(String productId, Product updatedProduct) {
    Product product = getProductById(productId);
    if (product != null) {
      product.setName(updatedProduct.getName());
      product.setPrice(updatedProduct.getPrice());
      product.setQuantity(updatedProduct.getQuantity());
      return product;
    } else {
      return null;
    }
  }
}
