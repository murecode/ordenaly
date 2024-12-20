package com.app.ordenaly.test;

import com.app.ordenaly.repository.OrderItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.app.ordenaly.model.entity.Order;
import com.app.ordenaly.model.entity.OrderItem;
import com.app.ordenaly.model.entity.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class OrderItemRepositoryTest {
  @Autowired
  private OrderItemRepository orderCartRepo;
  @Autowired
  private TestEntityManager entityManager;

  @Test
  void testAddOneOrderCart() {
    Product product = entityManager.find(Product.class, 2);
    Order order = entityManager.find(Order.class, 2);

    OrderItem newOrderItem = new OrderItem();
    newOrderItem.setOrder(order);
    newOrderItem.setProduct(product);
    newOrderItem.setQuantity(2);

    OrderItem savedOrderItem = orderCartRepo.save(newOrderItem);
  }

  @Test
  void testGetOrderItemsByOrder() {
    Order order = entityManager.find(Order.class, 2);

//    List<OrderCart> orderCarts = orderCartRepo.findByOrder(order);

//    assertEquals(2, orderCarts.stream().count());
  }

}