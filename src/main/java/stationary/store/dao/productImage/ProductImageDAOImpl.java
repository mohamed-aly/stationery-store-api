package stationary.store.dao.productImage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.model.ProductImage;

import java.util.List;

@Repository
public class ProductImageDAOImpl implements ProductImageDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ProductImage> getProductImages() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<ProductImage> theQuery =
                currentSession.createQuery("from ProductImage",
                        ProductImage.class);

        // execute query and get result list
        List<ProductImage> ProductImages = theQuery.getResultList();

        // return the results
        return ProductImages;
    }

    @Override
    public void saveProductImage(ProductImage theProductImage) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the ProductImage ... finally LOL
        currentSession.saveOrUpdate(theProductImage);

    }

    @Override
    public ProductImage getProductImage(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        ProductImage theProductImage = currentSession.get(ProductImage.class, theId);

        return theProductImage;
    }

    @Override
    public void deleteProductImage(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from ProductImage where id=:productImageId");
        theQuery.setParameter("productImageId", theId);

        theQuery.executeUpdate();
    }

}











