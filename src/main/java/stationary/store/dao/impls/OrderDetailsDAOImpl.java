package stationary.store.dao.impls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.dao.daos.OrderDetailsDAO;
import stationary.store.model.OrderDetails;

import java.util.List;

@Repository
public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<OrderDetails> getOrdersDetails() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<OrderDetails> theQuery =
                currentSession.createQuery("From OrderDetails", OrderDetails.class);

        // execute query and get result list
        List<OrderDetails> OrdersDetails = theQuery.getResultList();

        // return the results
        return OrdersDetails;
    }

    @Override
    public void saveOrderDetails(OrderDetails theOrderDetails) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the OrderDetails ... finally LOL
        currentSession.saveOrUpdate(theOrderDetails);

    }

    @Override
    public OrderDetails getOrderDetails(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        OrderDetails theOrderDetails = currentSession.get(OrderDetails.class, theId);

        return theOrderDetails;
    }

    @Override
    public void deleteOrderDetails(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from OrderDetails where id=:orderDetailsId");
        theQuery.setParameter("orderDetailsId", theId);

        theQuery.executeUpdate();
    }

}











