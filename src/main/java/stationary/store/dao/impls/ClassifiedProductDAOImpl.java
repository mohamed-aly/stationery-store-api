package stationary.store.dao.impls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.dao.daos.ClassifiedProductDAO;
import stationary.store.model.ClassifiedProduct;

import java.util.List;

@Repository
public class ClassifiedProductDAOImpl implements ClassifiedProductDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ClassifiedProduct> getClassifiedProducts() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<ClassifiedProduct> theQuery =
                currentSession.createQuery("from ClassifiedProduct",
                        ClassifiedProduct.class);

        // execute query and get result list
        List<ClassifiedProduct> ClassifiedProducts = theQuery.getResultList();

        // return the results
        return ClassifiedProducts;
    }

    @Override
    public void saveClassifiedProduct(ClassifiedProduct theClassifiedProduct) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the ClassifiedProduct ... finally LOL
        currentSession.saveOrUpdate(theClassifiedProduct);

    }

    @Override
    public ClassifiedProduct getClassifiedProduct(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        ClassifiedProduct theClassifiedProduct = currentSession.get(ClassifiedProduct.class, theId);

        return theClassifiedProduct;
    }

    @Override
    public void deleteClassifiedProduct(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from ClassifiedProduct where id=:classifiedProductId");
        theQuery.setParameter("classifiedProductId", theId);

        theQuery.executeUpdate();
    }

}











