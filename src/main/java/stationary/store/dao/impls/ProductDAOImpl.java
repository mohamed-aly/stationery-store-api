package stationary.store.dao.impls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.dao.daos.ProductDAO;
import stationary.store.model.Product;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getProducts() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Product> theQuery =
                currentSession.createQuery("from Product",
                        Product.class);

        // execute query and get result list
        List<Product> Products = theQuery.getResultList();

        // return the results
        return Products;
    }

    @Override
    public void saveProduct(Product theProduct) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the Product ... finally LOL
        currentSession.saveOrUpdate(theProduct);

    }

    @Override
    public Product getProduct(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Product theProduct = currentSession.get(Product.class, theId);

        return theProduct;
    }

    @Override
    public void deleteProduct(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Product where id=:productId");
        theQuery.setParameter("productId", theId);

        theQuery.executeUpdate();
    }

}











