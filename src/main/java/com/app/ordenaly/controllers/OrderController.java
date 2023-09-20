package com.app.ordenaly.controllers;

import com.app.ordenaly.models.Item;
import com.app.ordenaly.models.Order;
import com.app.ordenaly.DTOs.OrderDTO;
import com.app.ordenaly.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  @Autowired
  OrderService orderService;


  @GetMapping("/{id}")
  public Order findOrderById(@PathVariable("id") Integer id) {
    return orderService.getOrder(id);
  }

  @GetMapping("/list")
  public List<Order> listOrders() {
    return orderService.getAllOrders();
  }

  @DeleteMapping("/remove/{id}")
  public void removeOrderById(@PathVariable("id") Integer id) {
    orderService.deleteOrder(id);
  }


//  @PostMapping("/new-order")
//  public Order createOrder(@RequestBody Order order) {
//    return orderService.createOrder();
//  }
//
//  @PostMapping("/add-to-order/{id}")
//  void itemToOrder(@PathVariable("id") Item id){
//  }
//
//  @GetMapping(value = "/dto/{id}", produces = "application/json")
//  public OrderDTO findOrderDTO(@PathVariable("id") Integer id ) {
//    return orderService.getOrderDTO(id);
//  }

}