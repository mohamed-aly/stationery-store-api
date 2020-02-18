package stationary.store.service.orderDetails;

import stationary.store.model.OrderDetails;

import java.util.List;


public interface OrderDetailsService {

    List<OrderDetails> getOrdersDetails();

    void saveOrderDetails(OrderDetails theOrderDetails);

    OrderDetails getOrderDetails(int theId);

    void deleteOrderDetails(int theId);

}
