package stationary.store.dao.impls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.dao.daos.OfferDAO;
import stationary.store.model.Offer;

import java.util.List;

@Repository
public class OfferDAOImpl implements OfferDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Offer> getOffers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Offer> theQuery =
                currentSession.createQuery("from Offer",
                        Offer.class);

        // execute query and get result list
        List<Offer> Offers = theQuery.getResultList();

        // return the results
        return Offers;
    }

    @Override
    public void saveOffer(Offer theOffer) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the Offer ... finally LOL
        currentSession.saveOrUpdate(theOffer);

    }

    @Override
    public Offer getOffer(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Offer theOffer = currentSession.get(Offer.class, theId);

        return theOffer;
    }

    @Override
    public void deleteOffer(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Offer where id=:offerId");
        theQuery.setParameter("offerId", theId);

        theQuery.executeUpdate();
    }

}











