package stationary.store.dao.receipt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.dao.receipt.ReceiptDAO;
import stationary.store.model.OrderItem;

import java.util.List;

@Repository
public class ReceiptDAOImpl implements ReceiptDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<OrderItem> getReceipts() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<OrderItem> theQuery =
                currentSession.createQuery("from Receipt",
                        OrderItem.class);

        // execute query and get result list
        List<OrderItem> Receipts = theQuery.getResultList();

        // return the results
        return Receipts;
    }

    @Override
    public void saveReceipt(OrderItem theReceipt) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the Receipt ... finally LOL
        currentSession.saveOrUpdate(theReceipt);

    }

    @Override
    public OrderItem getReceipt(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        OrderItem theReceipt = currentSession.get(OrderItem.class, theId);

        return theReceipt;
    }

    @Override
    public void deleteReceipt(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Receipt where id=:receiptId");
        theQuery.setParameter("receiptId", theId);

        theQuery.executeUpdate();
    }

}











