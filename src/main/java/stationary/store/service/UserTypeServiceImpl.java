package stationary.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.daos.UserTypeDAO;
import stationary.store.model.UserType;

import java.util.List;


@Service
public class UserTypeServiceImpl implements UserTypeService {

    // need to inject userType dao
    @Autowired
    private UserTypeDAO userTypeDAO;

    @Override
    @Transactional
    public List<UserType> getUserTypes() {
        return userTypeDAO.getUserTypes();
    }

    @Override
    @Transactional
    public void saveUserType(UserType theUserType) {

        userTypeDAO.saveUserType(theUserType);
    }

    @Override
    @Transactional
    public UserType getUserType(int theId) {

        return userTypeDAO.getUserType(theId);
    }

    @Override
    @Transactional
    public void deleteUserType(int theId) {

        userTypeDAO.deleteUserType(theId);
    }
}





