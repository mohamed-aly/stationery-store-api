package stationary.store.dao.orderItem;

import stationary.store.model.OrderItem;
import stationary.store.model.Product;

import java.util.List;

public interface OrderItemDAO {

    List<OrderItem> getOrderItems();

    void saveOrderItem(OrderItem OrderItem);

    OrderItem getOrderItem(int id);

    void deleteOrderItem(int id);

}
