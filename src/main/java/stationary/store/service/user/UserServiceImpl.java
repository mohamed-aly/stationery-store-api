package stationary.store.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.user.UserDAO;
import stationary.store.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    // need to inject user dao
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public void saveUser(User theUser) {

        userDAO.saveUser(theUser);
    }

    @Override
    @Transactional
    public User getUser(int theId) {

        return userDAO.getUser(theId);
    }

    @Override
    @Transactional
    public void deleteUser(int theId) {

        userDAO.deleteUser(theId);
    }
}





