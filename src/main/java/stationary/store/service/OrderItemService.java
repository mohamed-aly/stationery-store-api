package stationary.store.service;

import stationary.store.model.OrderItem;

import java.util.List;


public interface OrderItemService {

    List<OrderItem> getOrderItems();

    void saveOrderItem(OrderItem theOrderItem);

    OrderItem getOrderItem(int theId);

    void deleteOrderItem(int theId);

}
