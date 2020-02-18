package stationary.store.dao.impls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.dao.daos.GradeDAO;
import stationary.store.model.Grade;

import java.util.List;

@Repository
public class GradeDAOImpl implements GradeDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Grade> getGrades() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Grade> theQuery =
                currentSession.createQuery("from Grade",
                        Grade.class);

        // execute query and get result list
        List<Grade> Grades = theQuery.getResultList();

        // return the results
        return Grades;
    }

    @Override
    public void saveGrade(Grade theGrade) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the Grade ... finally LOL
        currentSession.saveOrUpdate(theGrade);

    }

    @Override
    public Grade getGrade(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Grade theGrade = currentSession.get(Grade.class, theId);

        return theGrade;
    }

    @Override
    public void deleteGrade(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Grade where id=:gradeId");
        theQuery.setParameter("gradeId", theId);

        theQuery.executeUpdate();
    }

}











