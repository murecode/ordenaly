package com.app.ordenaly.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @ManyToOne
  @JoinColumn(name = "productId")
  private Product product;
  @ManyToOne
  @JoinColumn(name = "orderId")
  private Order order;
  private int quantity;

  public OrderItem() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Transient
  public int calculateSubtotal() {
    return this.product.getPrice() * getQuantity();
  }

  @Override
  public String toString() {
    return "{" +
            "id="       + id       + "\n" +
            "product="  + product  + "\n" +
            "order="    + order    + "\n" +
            "quantity=" + quantity + "\n" +
            '}';
  }

}
