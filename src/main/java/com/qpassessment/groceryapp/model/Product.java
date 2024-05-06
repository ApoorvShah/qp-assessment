package com.qpassessment.groceryapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
public class Product {

  private String id;
  private String name;
  private double price;
  private int quantity;

  @Override
  public String toString() {
    return "Product [id="
        + id
        + ", name="
        + name
        + ", price="
        + price
        + ", quantity="
        + quantity
        + "]";
  }
}
