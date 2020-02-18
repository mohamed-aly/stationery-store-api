package stationary.store.dao.impls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.dao.daos.ShipperDAO;
import stationary.store.model.Shipper;

import java.util.List;

@Repository
public class ShipperDAOImpl implements ShipperDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Shipper> getShippers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Shipper> theQuery =
                currentSession.createQuery("from Shipper",
                        Shipper.class);

        // execute query and get result list
        List<Shipper> Shippers = theQuery.getResultList();

        // return the results
        return Shippers;
    }

    @Override
    public void saveShipper(Shipper theShipper) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the Shipper ... finally LOL
        currentSession.saveOrUpdate(theShipper);

    }

    @Override
    public Shipper getShipper(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Shipper theShipper = currentSession.get(Shipper.class, theId);

        return theShipper;
    }

    @Override
    public void deleteShipper(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Shipper where id=:shipperId");
        theQuery.setParameter("shipperId", theId);

        theQuery.executeUpdate();
    }

}











