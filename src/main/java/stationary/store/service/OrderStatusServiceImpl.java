package stationary.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.daos.OrderStatusDAO;
import stationary.store.model.OrderStatus;

import java.util.List;


@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    // need to inject OrderStatus dao
    @Autowired
    private OrderStatusDAO orderStatusDAO;

    @Override
    @Transactional
    public List<OrderStatus> getOrderStatuses() {
        return orderStatusDAO.getOrderStatuses();
    }

    @Override
    @Transactional
    public void saveOrderStatus(OrderStatus theOrderStatus) {

        orderStatusDAO.saveOrderStatus(theOrderStatus);
    }

    @Override
    @Transactional
    public OrderStatus getOrderStatus(int theId) {

        return orderStatusDAO.getOrderStatus(theId);
    }

    @Override
    @Transactional
    public void deleteOrderStatus(int theId) {

        orderStatusDAO.deleteOrderStatus(theId);
    }
}





