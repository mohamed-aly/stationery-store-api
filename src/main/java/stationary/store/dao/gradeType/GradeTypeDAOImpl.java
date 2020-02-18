package stationary.store.dao.gradeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.model.GradeLevel;

import java.util.List;

@Repository
public class GradeTypeDAOImpl implements GradeTypeDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<GradeLevel> getGradeTypes() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<GradeLevel> theQuery =
                currentSession.createQuery("from GradeType",
                        GradeLevel.class);

        // execute query and get result list
        List<GradeLevel> GradeTypes = theQuery.getResultList();

        // return the results
        return GradeTypes;
    }

    @Override
    public void saveGradeType(GradeLevel theGradeType) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the GradeType ... finally LOL
        currentSession.saveOrUpdate(theGradeType);

    }

    @Override
    public GradeLevel getGradeType(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        GradeLevel theGradeType = currentSession.get(GradeLevel.class, theId);

        return theGradeType;
    }

    @Override
    public void deleteGradeType(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from GradeType where id=:gradeTypeId");
        theQuery.setParameter("gradeTypeId", theId);

        theQuery.executeUpdate();
    }

}











