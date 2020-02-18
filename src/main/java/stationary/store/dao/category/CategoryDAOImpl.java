package stationary.store.dao.category;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.dao.category.CategoryDAO;
import stationary.store.model.Category;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getCategories() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Category> theQuery =
                currentSession.createQuery("from Category",
                        Category.class);

        // execute query and get result list
        List<Category> Categories = theQuery.getResultList();

        // return the results
        return Categories;
    }

    @Override
    public void saveCategory(Category theCategory) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the Category ... finally LOL
        currentSession.saveOrUpdate(theCategory);

    }

    @Override
    public Category getCategory(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Category theCategory = currentSession.get(Category.class, theId);

        return theCategory;
    }

    @Override
    public void deleteCategory(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Category where id=:categoryId");
        theQuery.setParameter("categoryId", theId);

        theQuery.executeUpdate();
    }

}











