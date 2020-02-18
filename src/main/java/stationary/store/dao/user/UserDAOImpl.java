package stationary.store.dao.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.dao.user.UserDAO;
import stationary.store.model.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<User> theQuery =
                currentSession.createQuery("From User", User.class);

        // execute query and get result list
        List<User> Users = theQuery.getResultList();

        // return the results
        return Users;
    }

    @Override
    public void saveUser(User theUser) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the User ... finally LOL
        currentSession.saveOrUpdate(theUser);

    }

    @Override
    public User getUser(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        User theUser = currentSession.get(User.class, theId);

        return theUser;
    }

    @Override
    public void deleteUser(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from User where id=:userId");
        theQuery.setParameter("userId", theId);

        theQuery.executeUpdate();
    }

}











