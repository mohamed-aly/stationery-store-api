package stationary.store.dao.productPatch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.model.ProductPatch;

import java.util.List;

@Repository
public class ProductPatchDAOImpl implements ProductPatchDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ProductPatch> getProductPatches() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<ProductPatch> theQuery =
                currentSession.createQuery("from ProductPatch order by dateIn",
                        ProductPatch.class);

        // execute query and get result list
        List<ProductPatch> ProductPatches = theQuery.getResultList();

        // return the results
        return ProductPatches;
    }

    @Override
    public void saveProductPatch(ProductPatch theProductPatch) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the ProductPatch ... finally LOL
        currentSession.saveOrUpdate(theProductPatch);

    }

    @Override
    public ProductPatch getProductPatch(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        ProductPatch theProductPatch = currentSession.get(ProductPatch.class, theId);

        return theProductPatch;
    }

    @Override
    public void deleteProductPatch(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from ProductPatch where id=:productPatchId");
        theQuery.setParameter("productPatchId", theId);

        theQuery.executeUpdate();
    }

}











