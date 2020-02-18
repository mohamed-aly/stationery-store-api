package stationary.store.dao.impls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.dao.daos.CartItemDAO;
import stationary.store.model.CartItem;

import java.util.List;

@Repository
public class CartItemDAOImpl implements CartItemDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CartItem> getCartItems() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<CartItem> theQuery =
                currentSession.createQuery("from CartItem", CartItem.class);

        // execute query and get result list
        List<CartItem> cartItems = theQuery.getResultList();

        // return the results
        return cartItems;
    }

    @Override
    public void saveCartItem(CartItem theCartItem) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the CartItem ... finally LOL
        currentSession.saveOrUpdate(theCartItem);

    }

    @Override
    public CartItem getCartItem(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        CartItem theCartItem = currentSession.get(CartItem.class, theId);

        return theCartItem;
    }

    @Override
    public void deleteCartItem(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from CartItem where id=:cartItemId");
        theQuery.setParameter("cartItemId", theId);

        theQuery.executeUpdate();
    }

}











