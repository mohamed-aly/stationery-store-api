package stationary.store.dao.daos;

import stationary.store.model.Order;

import java.util.List;

public interface OrderDAO {

    List<Order> getOrders();

    void saveOrder(Order Order);

    Order getOrder(int id);

    void deleteOrder(int id);

}
