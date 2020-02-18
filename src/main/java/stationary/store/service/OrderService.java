package stationary.store.service;

import stationary.store.model.Order;

import java.util.List;


public interface OrderService {

    List<Order> getOrders();

    void saveOrder(Order theOrder);

    Order getOrder(int theId);

    void deleteOrder(int theId);

}
