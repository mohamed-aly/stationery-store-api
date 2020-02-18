package stationary.store.service.orderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.orderItem.OrderItemDAO;
import stationary.store.model.OrderItem;

import java.util.List;


@Service
public class OrderItemServiceImpl implements OrderItemService {

    // need to inject OrderItem dao
    @Autowired
    private OrderItemDAO orderItemDAO;

    @Override
    @Transactional
    public List<OrderItem> getOrderItems() {
        return orderItemDAO.getOrderItems();
    }

    @Override
    @Transactional
    public void saveOrderItem(OrderItem theOrderItem) {

        orderItemDAO.saveOrderItem(theOrderItem);
    }

    @Override
    @Transactional
    public OrderItem getOrderItem(int theId) {

        return orderItemDAO.getOrderItem(theId);
    }

    @Override
    @Transactional
    public void deleteOrderItem(int theId) {

        orderItemDAO.deleteOrderItem(theId);
    }
}





