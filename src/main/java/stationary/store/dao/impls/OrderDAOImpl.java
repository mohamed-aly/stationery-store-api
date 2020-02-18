package stationary.store.dao.impls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.dao.daos.OrderDAO;
import stationary.store.model.Order;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getOrders() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Order> theQuery =
                currentSession.createQuery("From Order", Order.class);

        // execute query and get result list
        List<Order> Orders = theQuery.getResultList();

        // return the results
        return Orders;
    }

    @Override
    public void saveOrder(Order theOrder) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the Order ... finally LOL
        currentSession.saveOrUpdate(theOrder);

    }

    @Override
    public Order getOrder(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Order theOrder = currentSession.get(Order.class, theId);

        return theOrder;
    }

    @Override
    public void deleteOrder(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Order where id=:orderId");
        theQuery.setParameter("orderId", theId);

        theQuery.executeUpdate();
    }

}











