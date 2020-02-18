package stationary.store.dao.orderStatus;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.model.OrderStatus;

import java.util.List;

@Repository
public class OrderStatusDAOImpl implements OrderStatusDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<OrderStatus> getOrderStatuses() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<OrderStatus> theQuery =
                currentSession.createQuery("from OrderStatus",
                        OrderStatus.class);

        // execute query and get result list
        List<OrderStatus> OrdersStatus = theQuery.getResultList();

        // return the results
        return OrdersStatus;
    }

    @Override
    public void saveOrderStatus(OrderStatus theOrderStatus) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the OrderStatus ... finally LOL
        currentSession.saveOrUpdate(theOrderStatus);

    }

    @Override
    public OrderStatus getOrderStatus(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        OrderStatus theOrderStatus = currentSession.get(OrderStatus.class, theId);

        return theOrderStatus;
    }

    @Override
    public void deleteOrderStatus(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from OrderStatus where id=:orderStatusId");
        theQuery.setParameter("orderStatusId", theId);

        theQuery.executeUpdate();
    }

}











