package stationary.store.dao.cart;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.dao.cart.CartDAO;
import stationary.store.model.Cart;

import java.util.List;

@Repository
public class CartDAOImpl implements CartDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Cart> getCarts() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Cart> theQuery =
                currentSession.createQuery("from Cart", Cart.class);

        // execute query and get result list
        List<Cart> Carts = theQuery.getResultList();

        // return the results
        return Carts;
    }

    @Override
    public void saveCart(Cart theCart) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the Cart ... finally LOL
        currentSession.saveOrUpdate(theCart);

    }

    @Override
    public Cart getCart(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Cart theCart = currentSession.get(Cart.class, theId);

        return theCart;
    }

    @Override
    public void deleteCart(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Cart where id=:CartId");
        theQuery.setParameter("CartId", theId);

        theQuery.executeUpdate();
    }

}











