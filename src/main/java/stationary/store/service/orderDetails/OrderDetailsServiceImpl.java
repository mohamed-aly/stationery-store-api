package stationary.store.service.orderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.orderDetails.OrderDetailsDAO;
import stationary.store.model.OrderDetails;

import java.util.List;


@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    // need to inject OrderDetails dao
    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Override
    @Transactional
    public List<OrderDetails> getOrdersDetails() {
        return orderDetailsDAO.getOrdersDetails();
    }

    @Override
    @Transactional
    public void saveOrderDetails(OrderDetails theOrderDetails) {

        orderDetailsDAO.saveOrderDetails(theOrderDetails);
    }

    @Override
    @Transactional
    public OrderDetails getOrderDetails(int theId) {

        return orderDetailsDAO.getOrderDetails(theId);
    }

    @Override
    @Transactional
    public void deleteOrderDetails(int theId) {

        orderDetailsDAO.deleteOrderDetails(theId);
    }
}





