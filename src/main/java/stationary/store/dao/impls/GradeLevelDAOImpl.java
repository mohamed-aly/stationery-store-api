package stationary.store.dao.impls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.dao.daos.GradeLevelDAO;
import stationary.store.model.GradeLevel;

import java.util.List;

@Repository
public class GradeLevelDAOImpl implements GradeLevelDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<GradeLevel> getGradeLevels() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<GradeLevel> theQuery =
                currentSession.createQuery("from GradeLevel",
                        GradeLevel.class);

        // execute query and get result list
        List<GradeLevel> GradeLevels = theQuery.getResultList();

        // return the results
        return GradeLevels;
    }

    @Override
    public void saveGradeLevel(GradeLevel theGradeLevel) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the GradeLevel ... finally LOL
        currentSession.saveOrUpdate(theGradeLevel);

    }

    @Override
    public GradeLevel getGradeLevel(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        GradeLevel theGradeLevel = currentSession.get(GradeLevel.class, theId);

        return theGradeLevel;
    }

    @Override
    public void deleteGradeLevel(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from GradeLevel where id=:gradeLevelId");
        theQuery.setParameter("gradeLevelId", theId);

        theQuery.executeUpdate();
    }

}











