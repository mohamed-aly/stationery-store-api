package stationary.store.service;

import stationary.store.model.OrderStatus;

import java.util.List;


public interface OrderStatusService {

    List<OrderStatus> getOrderStatuses();

    void saveOrderStatus(OrderStatus theOrderStatus);

    OrderStatus getOrderStatus(int theId);

    void deleteOrderStatus(int theId);

}
