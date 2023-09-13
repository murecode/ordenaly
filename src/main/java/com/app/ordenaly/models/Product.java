
package com.app.ordenaly.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class Product {
  @Transient
  private String type = "product";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "PRODUCT_NAME", length = 45)
  private String name;

  @Column(name = "DESCRIPTION", length = 90)
  private String description;

  @Column(name = "PRICE")
  private float price;

  @Column(name = "IN_STOCK")
  private Boolean inStock;


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public Boolean getInStock() {
    return inStock;
  }

  public void setInStock(Boolean inStock) {
    this.inStock = inStock;
  }

}