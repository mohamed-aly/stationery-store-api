package stationary.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.daos.OrderDAO;
import stationary.store.model.Order;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    // need to inject Order dao
    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional
    public List<Order> getOrders() {
        return orderDAO.getOrders();
    }

    @Override
    @Transactional
    public void saveOrder(Order theOrder) {

        orderDAO.saveOrder(theOrder);
    }

    @Override
    @Transactional
    public Order getOrder(int theId) {

        return orderDAO.getOrder(theId);
    }

    @Override
    @Transactional
    public void deleteOrder(int theId) {

        orderDAO.deleteOrder(theId);
    }
}





