package com.qpassessment.groceryapp.controller;

import com.qpassessment.groceryapp.model.Product;
import com.qpassessment.groceryapp.service.ProductService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/products")
public class AdminProductController {

  private final ProductService pService;

  public AdminProductController(ProductService pService) {
    this.pService = pService;
  }

  @PostMapping
  public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    Product newProduct = pService.addProduct(product);
    return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = pService.getAllProducts();
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  @GetMapping("/{productId}")
  public ResponseEntity<Product> getProductById(@PathVariable String productId) {
    Product product = pService.getProductById(productId);
    if (product != null) {
      return new ResponseEntity<>(product, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{productId}")
  public ResponseEntity<Product> updateProduct(
      @PathVariable String productId, @RequestBody Product product) {
    Product updatedProduct = pService.updateProduct(productId, product);
    if (updatedProduct != null) {
      return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
    boolean deleted = pService.deleteProduct(productId);
    if (deleted) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{productId}/inventory")
  public ResponseEntity<Product> updateInventory(
      @PathVariable String productId, @RequestBody int quantityToAdd) {
    Product updatedProduct = pService.updateInventory(productId, quantityToAdd);
    if (updatedProduct != null) {
      return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
